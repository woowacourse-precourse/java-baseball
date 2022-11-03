package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
    
    private static List<Integer> createRamdomNumbers() {
    	Set<Integer> randomNumberSet = new HashSet<>(3);
    	
    	while(true) {
    		int randomNumber = Randoms.pickNumberInRange(0, 9);
    		randomNumberSet.add(randomNumber);
    		
    		if(randomNumberSet.size()==3) {
    			break;
    		}
    	}
    	
    	List<Integer> randomNumberList = new ArrayList<>(3);
    	randomNumberList.addAll(randomNumberSet);
    	
    	return randomNumberList;
    }
}
