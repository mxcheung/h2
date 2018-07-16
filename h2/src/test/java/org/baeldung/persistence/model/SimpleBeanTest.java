package org.baeldung.persistence.model;

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

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SimpleBeanTest {

	
	@Before
	public void setup() throws Exception {
	}
	
	@Test
	public void whenJavaSerializedToXmlFile_thenCorrect() throws IOException {
	    XmlMapper xmlMapper = new XmlMapper();
	    xmlMapper.writeValue(new File("simple_bean.xml"), new SimpleBean());
	    File file = new File("simple_bean.xml");
	    assertNotNull(file);
	}
	
	@Test
	public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
	    XmlMapper xmlMapper = new XmlMapper();
	    SimpleBean value = 
	      xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", 
	      SimpleBean.class);
	    assertTrue(value.getX() == 1 && value.getY() == 2);
	}
	
	@Test
	public void whenJavaGotFromXmlFile_thenCorrect() throws IOException {
	    File file = new File("simple_bean.xml");
	    XmlMapper xmlMapper = new XmlMapper();
	    String xml = inputStreamToString(new FileInputStream(file));
	    SimpleBean value = xmlMapper.readValue(xml, SimpleBean.class);
	    assertTrue(value.getX() == 1 && value.getY() == 2);
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

