package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;

import methods.rest.*;

public class UA extends HttpOps
{
	
	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}
	
	@Test
	public void testNoUAGet() throws Exception 
	{
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/1", "GET", 403, "", false);
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}

	@Test
	public void testNoUAPost() throws Exception 
	{
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/1", "POST", 403, "", false);
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}
	
	
	@Test
	public void testNoUAPut() throws Exception 
	{
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/1", "PUT", 403, "", false);
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}
	
	
	@Test
	public void testNoUADelete() throws Exception 
	{
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/1", "DELETE", 403, "", false);
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}
}

