package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Random;

import methods.rest.*;

public class Put1 extends HttpOps
{
	
	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testPut1() throws Exception 
	{
		
		Random r = new Random();
		boolean random = false;
		int it;
		int itemNum =0;
		
		for(int i=0;i<testHash.get("TestData").pages.length;i++)
		{
			if(Integer.parseInt(testHash.get("TestData").items[i])>Integer.parseInt(testHash.get("TestData").maxItems))
			{
				it = Integer.parseInt(testHash.get("TestData").maxItems);
				random=true;
			}
			else
			{
				it=Integer.parseInt(testHash.get("TestData").items[i]);
				random=false;
			}
			
			for(int j=1;j<it;j++)
			{
				
				if(random==true)
				{
					itemNum = r.nextInt(Integer.parseInt(testHash.get("TestData").items[i])-1) + 1;
				}
				else
				{
					itemNum=j;
				}

				makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/"+itemNum, "PUT", 200, Integer.toString(itemNum), true);
	
			}
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		  
	}

}

