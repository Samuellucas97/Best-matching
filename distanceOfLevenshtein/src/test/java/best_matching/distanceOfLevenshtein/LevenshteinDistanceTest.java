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
public class LevenshteinDistanceTest {

	private static LevenshteinDistance bestMatching;
	
	@Parameter(0)
	public String wordOne;
	
	@Parameter(1)
	public String wordTwo;

	@Parameter(2)
	public Integer expectedDistanceOfLevenshtein;

	@BeforeClass
	public static void setUp() {
		//-> Setting up environment
		bestMatching  = new LevenshteinDistance();
	}

	@Parameters(name = "Run {index}: wordOne={0}, wordTwo={1} ")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {

			{ "gato", "gato", 0 },					//-> Same word
			{ "gato", "sapato", 3 },				//-> Different word: lenght(Left word) < lenght(Right word) 
			{ "mel", "meu", 1 },					//-> Different word: lenght(Left word) == lenght(Right word)
			{ "gato", "gt", 2 },					//-> Different word: lenght(Left word) > lenght(Right word)
			
			
													//-> CASES OTHERS 
			{ "mel", "mela", 1 },
			{ "gato", "gt", 2 },
			{ "gt", "gato", 2 },
			{ "samuel", "daniel", 3 },
			{ "rei", "abelha", 5 }					//-> Worst case
			
		});
	}
	
	@Test
	public void testShouldCalculateDistanceOfLevenshtein() {
		
		//-> Action
		Integer distanceOfLevenshtein = bestMatching.calculateLevenshteinDistance(wordOne, wordTwo);
		
		//-> Verification
		assertEquals(expectedDistanceOfLevenshtein, distanceOfLevenshtein);	
	}
}