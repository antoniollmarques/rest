package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;
import methods.rest.*;

public class Get4 extends HttpOps
{

	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testGet4() throws Exception 
	{

		makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[0]+"/?title=in+quibusdam+tempore+odit+est+dolorem", "GET", 200, "itaque id aut magnam", true);
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}


}

