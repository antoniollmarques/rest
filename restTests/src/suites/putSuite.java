package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	tests.rest.Put1.class,
	tests.rest.Put2.class,
	})
public class putSuite {
	
}
