package GenaricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class conatians all resuabale methids to perfroms actions on prperties
 * file
 * 
 * @author dileep
 *
 */
public class PropertiesUtility {

	private Properties property;

	public void propertyInti(String filepath) {
		FileInputStream fis = null;
		try {

			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();

		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method used to intilize properrties file
	 * 
	 * @param key
	 * @return 
	 */
	public String ReadData(String key) {
		return property.getProperty(key);

	}

	/**
	 * this method used to write and save to properties files
	 * 
	 * @param filepath
	 * @param key
	 * @param value
	 */

	public void WriteToProperties(String filepath, Object key, Object value) {
		property.put(key, value);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			property.store(fos, "Update");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
