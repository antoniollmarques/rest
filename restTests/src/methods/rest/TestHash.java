package methods.rest;

import java.util.HashMap;

public class TestHash extends ConfigHelp{
	
	public String failSentence;
	public String webS;
	public String[] pages;
	public String[] items;
	public String[] words;
	public String maxItems;
	public String msg;
	public String code;
	public static HashMap<String, TestHash> testHash = new HashMap<String, TestHash>();
	
	public TestHash(String failSentence, String msg, String code) throws Exception 
	{
		super();
		this.failSentence = failSentence;
		this.webS = getPropertiesFileValue("webService");
		this.pages = splitString(getPropertiesFileValue("pages"));
		this.items = splitString(getPropertiesFileValue("itemsPerPage"));
		this.words = splitString(getPropertiesFileValue("word"));
		this.maxItems = getPropertiesFileValue("maxItems");
		this.msg = msg;
		this.code = code;
	}

	public TestHash()
	{

	}
	
	
}
