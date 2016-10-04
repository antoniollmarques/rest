package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;
import methods.rest.*;

public class Get3 extends HttpOps
{
	
	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testGet3() throws Exception 
	{
		makeOpGetResults(testHash.get("TestData").webS+"/abcd", "GET", 404, "", true);
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/"+testHash.get("TestData").items[i]+"/abcd", "GET", 404, "", true);
			
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/abcd", "GET", 404, "", true);
		}		
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}


}

