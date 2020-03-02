package best_matching.distanceOfLevenshtein;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class BestMatchingTest {

	private static BestMatching bestMatch;

	@Parameter(0)
	public String word;
	
	@Parameter(1)
	public ArrayList<String> vocabulary;
	
	@Parameter(2)
	public String expectedWord;
	
	
	@BeforeClass
	public static void setUp() {
		//-> Setting up environment
		bestMatch = new BestMatching();
	}
	

	@Parameters(name = "Run {index}: wordOne={0}, wordTwo={1} ")
	public static Collection<Object[]> buildData() {
		
		return Arrays.asList(new Object[][] {

			{ "gato", Arrays.asList( new String[]{"gato"} ), "gato"},					//-> Best case	
			{ "gato", Arrays.asList( new String[]{"sapato","gato"} ), "gato"},
			{ "mel",  Arrays.asList( new String[]{"mala","miau"} ), "mala"},	
			{ "gato", Arrays.asList( new String[]{"gt","goto"} ), "goto"},
			{ "mel",  Arrays.asList( new String[]{"raio","lã"} ), "lã"}
			
		});
	}

	
	@Test
	public void testShouldCalculateMinumLevenshteinDistance() {
		
		//-> Action
		String  wordMinumLevenshteinDistance = bestMatch.calculateWordMinumLevenshteinDistance(word, vocabulary);
		
		//-> Verification
		assertEquals(expectedWord, wordMinumLevenshteinDistance);
	}

}