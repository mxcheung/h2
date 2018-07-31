package org.maxcheung.h2boot2.service;

import java.util.List;

import com.google.common.collect.ImmutableTable;


public interface SimpleService {

	/**
	 * Return Environment specific properties based on Key Value.
	 * @param key to retrieve .
	 * @return property value .
	 */
	String getValue(String key);
	
	ImmutableTable<String, String, String> processList(List<String> strings);
	
}