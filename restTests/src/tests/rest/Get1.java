package tests.rest;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;
import methods.rest.*;

public class Get1 extends HttpOps
{
	
	public Get1() throws Exception {
		super();
	}

	@Before
	public void setUp() throws Exception 
	{
		testHash.put("TestData", new TestHash("","",""));
	}

	@Test
	public void testGet1() throws Exception 
	{
		
		Random r = new Random();
		boolean random = false;
		int it;
		int itemNum =0;
		
		makeOpGetResults(testHash.get("TestData").webS, "GET", 200, "JSONPlaceholder", true);
		
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
			
			for(int j=0;j<it;j++)
			{
				
				if(random==true)
				{
					itemNum = r.nextInt(Integer.parseInt(testHash.get("TestData").items[i])-1) + 1;
				}
				else
				{
					itemNum=j;
				}
				
				if(j!=0)
				{
					System.out.println("Number of items -> "+it);
					System.out.println("items nr -> "+j);
					makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i]+"/"+itemNum, "GET", 200, testHash.get("TestData").words[i], true);
				}
				else
				{
					makeOpGetResults(testHash.get("TestData").webS+"/"+testHash.get("TestData").pages[i], "GET", 200, testHash.get("TestData").words[i], true);
				}
				
			}
		}
		
		if(!testHash.get("TestData").failSentence.equals(""))
		{
			fail(testHash.get("TestData").failSentence);
		}
		
	}


}

