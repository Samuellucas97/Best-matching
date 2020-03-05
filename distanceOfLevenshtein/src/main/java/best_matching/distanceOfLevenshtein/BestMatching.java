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
		
		Integer minumDistanceOfLevenshtein = -1;
		Integer actualDistance = 0;
		
		String wordMinumDistance = "";
		
		for (Integer i = 0; i < vocabulary.size(); ++i) {
			actualDistance = levDist.calculateLevenshteinDistance(a, vocabulary.get(i));
			
			if ( i == 0 ) {
				wordMinumDistance = vocabulary.get(0);
				minumDistanceOfLevenshtein = actualDistance;
			
			}
			else {
				if ( minumDistanceOfLevenshtein > actualDistance ) {
					wordMinumDistance = vocabulary.get(i);
					minumDistanceOfLevenshtein = actualDistance;
				}
			}
			
		}
		
		return wordMinumDistance;
	}
}
