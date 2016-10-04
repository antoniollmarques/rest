package methods.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelp{

	public String getPropertiesFileValue(String property) throws Exception
	{
		
		String configPath = new File("resources/config.properties").getAbsolutePath();
		
		Properties prop = new Properties();
		InputStream input = null;

		String value="";
		
		try 
		{
			input = new FileInputStream(configPath);

			prop.load(input);
			
			value = prop.getProperty(property);
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} finally 
		{
			if (input != null) 
			{
				try {
					input.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		return value;
		
	}
	
	
	public String[] splitString(String strToSplit) throws Exception
	{
		
		String[] strs = strToSplit.split(",");
		
		return strs;
		
	}
	
	public String getResponseMsgId(String msg) throws Exception
	{
		String[] strs = msg.split("\"id\": ");
				
		if(strs[1].contains(","))
		{
			strs = strs[1].split(",");
		}
		else
			if(strs[1].contains("}"))
			{
				strs = strs[1].split("}");
			}
		
		return strs[0];
		
	}
}
