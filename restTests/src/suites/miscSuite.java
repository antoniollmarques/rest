package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	tests.rest.UA.class,
	tests.rest.DeleteGet.class,
	tests.rest.PostGet.class
	})
public class miscSuite {
	
}
