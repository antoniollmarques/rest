package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import methods.rest.*;

public class PostGet extends HttpOps
{	
	
	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testPostGet() throws Exception 
	{
		String[] createdItem = new String[testHash.get("TestData").pages.length];
		HttpURLConnection conn = null;
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{						
			conn = postOp(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i],true);
			
			checkConnectionResponse(conn, "POST", 201);
			
			ReadBuffer(conn);
			
			createdItem[i] = getResponseMsgId(testHash.get("TestData").msg);
			
			checkStringBufferResponse(conn, "POST", "test");
		}
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/"+createdItem[i], "GET", 200, "", true);
		}

		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}


}

