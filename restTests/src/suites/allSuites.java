package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	suites.getSuite.class,
	suites.putSuite.class,
	suites.miscSuite.class,
	})
public class allSuites {
	
}
