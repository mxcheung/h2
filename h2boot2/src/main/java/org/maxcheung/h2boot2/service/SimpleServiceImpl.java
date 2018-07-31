package org.maxcheung.h2boot2.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.common.io.Files;
import com.google.common.io.Resources;

@Service
public class SimpleServiceImpl implements SimpleService {

    final String profile;
	 
	private static final String ENV_PROPERTIES = "environmentTable.csv";
	private Splitter splitter = Splitter.on(',');
	private final ImmutableTable<String, String, String> environmentTable;
	
	@Autowired
	public SimpleServiceImpl(@Value("${spring.profile}") final String profile) throws IOException {
		this.profile = profile;
		environmentTable = initialise();
	}

	
	@Override
	public String getValue(String key) {
		String val = environmentTable.get(profile, key);
		return Objects.requireNonNull(val, String.format("Unable to locate property Profile: %s , Key: %s", profile, key));
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
		File file = FileUtils.toFile(Resources.getResource(ENV_PROPERTIES));
		return processList(Files.readLines(file, Charsets.UTF_8));
	}

	private ImmutableTable<String, String, String> processText(String text) {
		List<String> values = splitter.splitToList(text);
		return ImmutableTable.of(values.get(0), values.get(1), values.get(2));
	}
}