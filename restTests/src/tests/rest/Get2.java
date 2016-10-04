package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;
import methods.rest.*;

public class Get2 extends HttpOps
{
	
	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testGet2() throws Exception 
	{
		int invalidItem = 0;
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			invalidItem = Integer.parseInt(testHash.get("TestData").items[i]) + 1;
			
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/"+invalidItem, "GET", 404, "", true);
			
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/0", "GET", 404, "", true);
			
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/-1", "GET", 404, "", true);
		}		
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}


}

