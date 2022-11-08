package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
	private static Map<Character, Integer> numberIndexMap;

    public Computer() {
        setNumberIndexMap(getNumbers());
    }

    
    //generate random number using Randoms
    //loop until each 3 numbers are different 
    
    private static List<Integer> getNumbers() {
    	
        List<Integer> computerNumber = new ArrayList<>();
        
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }

    // assign 3 number's index to Map
    private static void setNumberIndexMap(List<Integer> numbers) {
    	
        Map<Character, Integer> map = new HashMap<>();

        for (int index = 0; index < 3; index++) {
        	
            int number = numbers.get(index);
            map.put((char) (number + '0'), index);
        }

        numberIndexMap = map;
    }

    public Map<Character, Integer> getNumberIndexMap() {
        return numberIndexMap;
    }
}
