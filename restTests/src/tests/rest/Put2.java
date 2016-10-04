package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;

import methods.rest.*;

public class Put2 extends HttpOps
{
	
	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testPut2() throws Exception 
	{
		
		makeOpGetResults(testHash.get("TestData").webS, "PUT", 404, "", true);
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i], "PUT", 404, "" ,true);
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}

}

