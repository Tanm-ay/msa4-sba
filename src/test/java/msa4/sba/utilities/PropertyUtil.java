package msa4.sba.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil
{

	public String getFromProperty(String fileName, String key)
	{
		LogUtil l = new LogUtil();
		Properties p = null;
		try
		{
			p = new Properties();
			FileInputStream fs = new FileInputStream("./Property Files/" + fileName + ".properties");
			p.load(fs);
		}
		catch (FileNotFoundException f)
		{
			l.error("Could not find the " + fileName + ".properties property file");
			f.getMessage();
		}
		catch (IOException i)
		{
			l.error("Failed to load the file from input");
			i.getMessage();
		}
		return p.getProperty(key);
	}
}
