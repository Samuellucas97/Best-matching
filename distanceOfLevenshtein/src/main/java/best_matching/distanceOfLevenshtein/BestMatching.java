package best_matching.distanceOfLevenshtein;


/**
 * Contains aplication of Levenshtein distance algorithm with the use of vocabulary 
 * @author Samuel Lucas de Moura Ferino
 *
 */
public class BestMatching {
	
	//-> Attributes

	private LevenshteinDistance levDist;

	//-> Methods  **PUBLICS**

	public BestMatching() { 
		levDist = new LevenshteinDistance();
	}
	
	public String calculateWordMinumLevenshteinDistance(String a, String[] vocabulary) {
		
		Integer minumDistanceOfLevenshtein = -2;
		Integer actualDistance = -1;
		
		String wordMinumDistance = "";
		
		for (Integer i = 0; i < vocabulary.length; ++i) {
			actualDistance = levDist.calculateLevenshteinDistance(a, vocabulary[i]);
			
			if ( minumDistanceOfLevenshtein < actualDistance ) {
				wordMinumDistance = vocabulary[i];
				minumDistanceOfLevenshtein = actualDistance;
			}
		}
		
		return wordMinumDistance;
	}
}
