Environment Setup:

1. Download and install the latest JAVA JDK.
2. Download and install Apache Ant.
3. Add JAVA and Apache Ant bin folder path to your Environment Variables PATH.



How to Run:

1. Download the project to your machine.
2. In order to run the tests, run RunTests.bat file(located in project root) or you can also open a JAVA IDE and run suites.allSuites.java test suite.
3. If running using the RunTests.bat, test results can be checked at index.html file(located inside junit(located at project root) folder).



Framework design:

The framework has three main classes:


- HttpOps

Contains the HTTP GET, POST, PUT and DELETE methods(PATCH, OPTIONS, HEAD, TRACE and CONNECT were not implemented). 
Contains a method which reads the response messages.
Two methods that check if response codes and response messages are the expected ones.


- ConfigHelp

Reads config.properties file located in resources folder.

config.properties file has 4 parameters:
webService, Configuration of the ReST Web Service that we are testing.
pages, All web service pages separated by comma(e.g. page1,page10,page20).
itemsPerPage, The number of items of previous pages(e.g. 10,20,500, it means that page1 has 10 items, page10 20 items and page20 500 items)
words, The word that we try to find(for each page) when doing a HTTP GET(e.g. following the example above).

'pages', 'itemsPerPage' and 'words' parameters were created since web service structure could be changed (or we can use this framework to test another similar web service).
'words', this was the implemented solution with the time constraints. It is not the best approach to check HTTP GET response messages.


- TestHash

Contains an HashMap which keep the following information while tests are running:
Fail sentence, the fail message(if empty, means test passed).
Response Message - Last response message.
Response Code - Last response code.
config.properties parameters(The ones shown above).

		
			
Tests:

- TestGet1 and testPut1
Before the correspondent request, checks if the number of items of the page in test is bigger than 'maxItems'. If so, it makes the request to only 'maxItems' items(randomly), if not, requests are done to all available items. 
This approach was chosen because when we have a huge amount of items in a page it could take too long to run it. 
'maxItems' are now configured with 1000 items as a good sample, in order to run the framework faster(review purpose) configure it to a smaller value(e.g. 50 might take few minutes).
