package org.maxcheung.h2boot2.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableTable;

public class SimpleServiceImplTest {

    private SimpleService simpleService;
    
    
	@Before
	public void setup() throws IOException {
		simpleService = new SimpleServiceImpl("dev");
	}
	
	@Test
	public void shouldGetValuesByEnvironment() throws IOException {
		simpleService = new SimpleServiceImpl("dev");
		assertEquals("v1",simpleService.getValue("key1"));
		simpleService = new SimpleServiceImpl("sit");
		assertEquals("v2",simpleService.getValue("key1"));
	}

	@Test
	public void shouldGetTableValue() {
		List<String> list = new ArrayList<String>();
		list.add("dev,key1,v1");
		list.add("sit,key1,v2");
		ImmutableTable<String, String, String> table = simpleService.processList(list);
		assertEquals("v1",table.get("dev", "key1"));
		assertEquals("v2",table.get("sit", "key1"));
		assertEquals("v1",table.get("dev", "key1"));
	}



}
