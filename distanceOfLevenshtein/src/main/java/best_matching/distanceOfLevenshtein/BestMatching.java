package best_matching.distanceOfLevenshtein;

import java.util.List;

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
	
	public String calculateWordMinumLevenshteinDistance(String a, List<String> vocabulary) {
		
		Integer minumDistanceOfLevenshtein = -2;
		Integer actualDistance = -1;
		
		String wordMinumDistance = "";
		
		for (Integer i = 0; i < vocabulary.size(); ++i) {
			actualDistance = levDist.calculateLevenshteinDistance(a, vocabulary.get(i));
			
			if ( minumDistanceOfLevenshtein < actualDistance ) {
				wordMinumDistance = vocabulary.get(i);
				minumDistanceOfLevenshtein = actualDistance;
			}
		}
		
		return wordMinumDistance;
	}
}
