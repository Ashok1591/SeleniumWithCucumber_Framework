package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static Properties props = new Properties();

	public Properties getProps() throws IOException {
		FileInputStream read = null;
		final String propsFileName = ".//configFile//config.properties";

		if(props.isEmpty()) {
			try {	
				read = new FileInputStream(propsFileName);
				props.load(read);
			}
			catch(IOException  e) {
				e.printStackTrace();
			}
			finally{
				if(read != null){
					read.close();
				}
			}

		}
		return props;
	}
}
