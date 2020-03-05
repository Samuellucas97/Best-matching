package best_matching.distanceOfLevenshtein;

/**
 * Implementation of Big Data algorithm, Levenshtein distance
 * @author Samuel Lucas de Moura Ferino
 *
 */
public class LevenshteinDistance {
	
	//-> Attributes
	
	private String a;
	private String b;
	
	public LevenshteinDistance() { 
		this.a = "";
		this.b = "";
	}
	
	//-> Methods  **PRIVATES**
	
	private Integer indication(Integer i, Integer j) {
		
		if ( this.a.charAt(i-1) != this.b.charAt(j-1) )
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
	
	public Integer calculateLevenshteinDistance(String a, String b) {
		
		this.a = a;
		this.b = b;
		
		return lev( a.length(), b.length() );
	}
}
