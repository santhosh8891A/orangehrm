package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File path = new File("Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(path);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// Method to read confrig file
	public String getPropertyFromConfingFile(String data) {
		String dataFromFile = pro.getProperty(data);
		return dataFromFile;
	}

}
