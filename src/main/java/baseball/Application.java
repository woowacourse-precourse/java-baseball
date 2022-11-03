package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    
    private static List<Integer> createRamdomNumbers(int startNumber, int endNumber, int size) {
    	
    	Set<Integer> randomNumberSet = new HashSet<>(size);
    	
    	while(true) {
    		int randomNumber = Randoms.pickNumberInRange(startNumber, endNumber);
    		randomNumberSet.add(randomNumber);
    		
    		if(randomNumberSet.size()==size) {
    			break;
    		}
    	}
    	
    	List<Integer> randomNumberList = new ArrayList<>(size);
    	randomNumberList.addAll(randomNumberSet);
    	
    	return randomNumberList;
    }
    
}
