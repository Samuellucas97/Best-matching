package best_matching.distanceOfLevenshtein;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class BestMatchingTest {

	private static BestMatching bestMatching;
	
	@Parameter(0)
	public String wordOne;
	
	@Parameter(1)
	public String wordTwo;

	@Parameter(2)
	public Integer expectedDistanceOfLevenshtein;

	@BeforeClass
	public static void setUp() {
		// / Setting up environment
		bestMatching  = new BestMatching();
	}

	@Parameters(name = "Run {index}: wordOne={0}, wordTwo={1} ")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {

			{ "gato", "gato", 0 },
			{ "gato", "sapato", 3 },
			{ "mel", "meu", 1 }

		});
	}
	
	
	@Test
	public void testShouldCalculateDistanceOfLevenshtein() {
		
		//-> Action
		Integer distanceOfLevenshtein = bestMatching.calculateDistanceOfLevenshtein(wordOne, wordTwo);
		
		//-> Verification
		assertEquals(expectedDistanceOfLevenshtein, distanceOfLevenshtein);	
	}
}