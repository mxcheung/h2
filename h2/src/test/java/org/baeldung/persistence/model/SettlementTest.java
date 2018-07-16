package org.baeldung.persistence.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SettlementTest {

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void whenJavaSerializedToXmlFile_thenCorrect() throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		Settlement settlement = new Settlement();
		settlement.setSettlementSystemId(84422L);
		settlement.setSettlementType(SettlementType.NORMAL);
		settlement.setEarmarkFlag(EarmarkFlag.UNEARMARK);
		xmlMapper.writeValue(new File("settlement.xml"), settlement);
		File file = new File("settlement.xml");
		assertNotNull(file);
	}

	@Test
	public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		SimpleBean value = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
		assertTrue(value.getX() == 1 && value.getY() == 2);
	}

	@Test
	public void whenJavaGotFromXmlFile_thenCorrect() throws IOException {
		File file = new File("settlement.xml");
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		xmlMapper.registerModule(javaTimeModule);
		String xml = inputStreamToString(new FileInputStream(file));
		Settlement value = xmlMapper.readValue(xml, Settlement.class);
		assertTrue(value.getSettlementSystemId() == 84422);
		assertEquals(SettlementType.NORMAL ,value.getSettlementType());
	}

	public static String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

}
