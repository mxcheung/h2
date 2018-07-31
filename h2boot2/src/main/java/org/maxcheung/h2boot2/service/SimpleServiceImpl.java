package org.maxcheung.h2boot2.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.apache.commons.io.FileUtils;

@Service
public class SimpleServiceImpl implements SimpleService {

	private static final String ENV_PROPERTIES = "environmentTable.csv";
	private Splitter splitter = Splitter.on(',');
	private final ImmutableTable<String, String, String> environmentTable;
	
	public SimpleServiceImpl() throws IOException {
		environmentTable = initialise();
	}

	@Override
	public String getValue(String env, String key) {
		return environmentTable.get(env, key);
	}

	@Override
	public ImmutableTable<String, String, String> processList(List<String> strings) {
	    return strings.stream()
	            .map(this::processText)
	            .flatMap(table -> table.cellSet().stream())
	            .collect(ImmutableTable.toImmutableTable(
	                    Table.Cell::getRowKey,
	                    Table.Cell::getColumnKey,
	                    Table.Cell::getValue
	            ));
	}

	private ImmutableTable<String, String, String> initialise() throws IOException {
		URL url = Resources.getResource(ENV_PROPERTIES);
		File file = FileUtils.toFile(url);
		List<String> result = Files.readLines(file, Charsets.UTF_8);
		return processList(result);
	}

	private ImmutableTable<String, String, String> processText(String text) {
		List<String> values = splitter.splitToList(text);
		return ImmutableTable.of(values.get(0), values.get(1), values.get(2));
	}
}