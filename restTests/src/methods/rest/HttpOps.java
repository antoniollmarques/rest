package methods.rest;

import java.io.*;
import java.net.*;

public class HttpOps extends TestHash
{

	public static HttpURLConnection getOp(String url, boolean user) throws IOException 
	{
		
		URL urlFormatted = new URL(url);
		HttpURLConnection conn =(HttpURLConnection) urlFormatted.openConnection();
		
		if(user == true)
		{
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		}

		
		System.out.println("Get Request -> "+url);
		System.out.println("Get Response -> "+conn.getResponseCode());
  
  		return conn;
		  
	}
	
	
	public static HttpURLConnection postOp(String urlStr, boolean user) throws Exception 
	{
		
		String[] paramName = {"title"};
		String[] paramVal = {"test"};
		URL url = new URL(urlStr);
	  	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	  	
		if(user == true)
		{
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		}
	  	
	  	conn.setRequestMethod("POST");
	  	conn.setDoOutput(true);
	  	conn.setDoInput(true);
	  	conn.setUseCaches(false);
	  	conn.setAllowUserInteraction(false);
	  	conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	
	  	OutputStream out = conn.getOutputStream();
	  	Writer writer = new OutputStreamWriter(out, "UTF-8");
	  	for (int i = 0; i < paramName.length; i++) 
	  	{
	  
			writer.write(paramName[i]);
			writer.write("=");
			writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
			writer.write("&");
		
		}
		writer.close();
		out.close();
		
		System.out.println("Post Request -> "+urlStr);
		System.out.println("Post Response -> "+conn.getResponseCode());
			  
  		return conn;
		  
	}

	public static HttpURLConnection putOp(String urlStr, boolean user) throws Exception
	{
		
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		if(user == true)
		{
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		}
		
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
		out.write("Resource content");
		out.close();
		
		System.out.println("Put Request -> "+urlStr);
		System.out.println("Put Response -> "+conn.getResponseCode());
				
		return conn;
	}
	
	public static HttpURLConnection deleteOp(String urlStr, boolean user) throws Exception 
	{
		
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		
		if(user == true)
		{
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		}
		
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded" );
		conn.setRequestMethod("DELETE");
		conn.connect();
		
		System.out.println("Delete Request -> "+urlStr);
		System.out.println("Delete Response -> "+conn.getResponseCode());
  
  		return conn;
		  
	}
	
	public static void ReadBuffer(HttpURLConnection connection) throws Exception
	{
		String line;
		StringBuilder sb = null;
		BufferedReader br;
		String result;
		
		try
		{
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			sb = new StringBuilder();
			
			while ((line = br.readLine()) != null) 
			{
			    sb.append(line);
			}
			
			br.close();
		    
		    result = sb.toString();
		    
		}
		catch(Exception ex)
		{
			System.out.println("An exception was thrown!");
			
			result = "";
		}
		
		System.out.println("SB-> "+result);
		
		testHash.put("TestData", new TestHash(testHash.get("TestData").failSentence, result, testHash.get("TestData").code));
	    
	}
	
	public static void checkStringBufferResponse(HttpURLConnection conn, String request , String expected) throws Exception
	{
		if(!testHash.get("TestData").msg.contains(expected))
		{
			testHash.put("TestData", new TestHash(testHash.get("TestData").failSentence+"\n"+"While sending an HTTP "+request+"("+conn.getURL()+") the expected text("+expected+") was not found!",testHash.get("TestData").msg,testHash.get("TestData").code));
		}
	}
	
	public static void checkConnectionResponse(HttpURLConnection conn, String request, int expectedResponseCode) throws Exception
	{
		try
		{
			if(conn.getResponseCode() != expectedResponseCode)
			{
				testHash.put("TestData", new TestHash(testHash.get("TestData").failSentence+"\n"+"While sending HTTP "+request+"("+conn.getURL()+"), we were expecting "+expectedResponseCode+" response code and we got "+conn.getResponseCode()+"("+conn.getResponseMessage()+")!",testHash.get("TestData").msg,testHash.get("TestData").code));
			}
		}
		catch(Exception ex)
		{
			testHash.put("failSentence", new TestHash(testHash.get("failSentence")+"\n"+"While sending HTTP "+request+"("+conn.getURL()+"), Test failed with -> "+ex+" Exception",testHash.get("TestData").msg,testHash.get("TestData").code));
		}
		
	}
	
	public static void makeOpGetResults(String url, String request ,int expectedResponseCode, String expectedResponseData, boolean withUserAgent) throws Exception
	{
		HttpURLConnection conn = null;
		
		if(request.equals("GET"))
		{
			conn = getOp(url,withUserAgent);
		}
		else
			if(request.equals("POST"))
			{
				conn = postOp(url,withUserAgent);
			}
			else
				if(request.equals("PUT"))
				{
					conn = putOp(url,withUserAgent);
				}
				else
					if(request.equals("DELETE"))
					{
						conn = deleteOp(url,withUserAgent);
					}
		
		checkConnectionResponse(conn, request, expectedResponseCode);
		
		ReadBuffer(conn);
		
		System.out.println("ExpectedData -> "+expectedResponseData);
		
		checkStringBufferResponse(conn, request, expectedResponseData);
		
	}
}
