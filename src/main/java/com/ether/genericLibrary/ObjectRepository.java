package com.ether.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author meena
 *
 */
public class ObjectRepository {

	public Properties getObjectPage(String Path) throws IOException {
		FileInputStream fis = new FileInputStream(Path);
		Properties page = new Properties();
		page.load(fis);
		return page;
	}

}
