package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;

import methods.rest.*;

public class DeleteGet extends HttpOps
{

	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testDeleteGet() throws Exception 
	{
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/1", "DELETE", 200, "", true);
			
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/1", "GET", 404, "", true);
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}

}

