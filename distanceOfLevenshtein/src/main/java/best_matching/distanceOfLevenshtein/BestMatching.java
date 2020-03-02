package best_matching.distanceOfLevenshtein;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Big Data algorithm, distance of Levenshtein
 * @author Samuel Lucas
 *
 */
public class BestMatching {
	
	//-> Attributes
	
	private String a = "";
	private String b = "";
	
	private ArrayList<String> vocabulary = new ArrayList<String>();
	
	
	public BestMatching( ArrayList<String> vocabulary) { 
		this.vocabulary = vocabulary.clone();	
	}
	
	//-> Methods  **PRIVATES**
		
	private Integer indication(Integer i, Integer j) {
		if ( a.charAt(i-1) != b.charAt(j-1) )
			return 1;
		
		return 0;
	}

	private Integer lev(Integer i, Integer j) {
		
		if ( Math.min(i, j) == 0 ) 
			return Math.max(i, j);
		
		return 	Math.min( 		(lev(i-1,j)   + 1),	
					Math.min(   (lev(i,j-1)   + 1), 
								(lev(i-1,j-1) + indication(i, j))
							)
				);
	}	

	//-> Methods  **PUBLICS**
	
	public Integer calculateDistanceOfLevenshtein(String a, String b) {
		this.a = a;
		this.b = b;
		
		return lev( a.length(), b.length() );
	}
	
	public Integer calculateMinumDistanceOfLevenshtein(String a) {
		Integer minumDistanceOfLevenshtein = -2;
		Integer actualDistance = -1;
		for (Integer i = 0; i < this.vocabulary.lenght(); ++i) {
			actualDistance = calculateDistanceOfLevenshtein(a, this.vocabulary.indexOf(i));
			
			if ( minumDistanceOfLevenshtein < actualDistance ) {
				minumDistanceOfLevenshtein = actualDistance;
			}
		}
		
		return minumDistanceOfLevenshtein;
	}
}
