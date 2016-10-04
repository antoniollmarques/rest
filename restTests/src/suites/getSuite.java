package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	tests.rest.Get1.class,
	tests.rest.Get2.class,
	tests.rest.Get3.class,
	tests.rest.Get4.class,
	})
public class getSuite {
	
}
