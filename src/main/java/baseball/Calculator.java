package baseball;

import java.util.Map;

public class Calculator {

	// Compute User's score 
    public static int calculateScore(Computer computer, String userGameNumber) {
        Map<Character, Integer> numberIndexMap = computer.getNumberIndexMap();
        int score = 0;

        // strike 10
    	// ball 1
    	// nothing 0
        for (int index = 0; index < userGameNumber.length(); index++) {
        	
            char currentUserNumber = userGameNumber.charAt(index);
            
            if (numberIndexMap.containsKey(currentUserNumber)) {
                score += getScoreByIndex(numberIndexMap.get(currentUserNumber), index);
            }
        }

        return score;
    }
    

    // return score comparing between numbers
    private static int getScoreByIndex(int numberIndex, int index) {
    	
    	// same
        if (numberIndex == index) return 10;
        
        //differ
        return 1;
    }
}
