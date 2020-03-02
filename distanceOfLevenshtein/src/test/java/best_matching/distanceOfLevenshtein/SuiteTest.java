package best_matching.distanceOfLevenshtein;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	LevenshteinDistanceTest.class,
	BestMatching.class
})
public class SuiteTest {
}
