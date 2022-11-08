package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현   
        gameStart();
    }
    
    public static void gameStart() {
    	List<Integer> computerPickNums = computerPick();
    	
    }
    
    public static List<Integer> computerPick() {
    	List<Integer> computerPickNums = new ArrayList<>();
    	while (computerPickNums.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computerPickNums.contains(randomNumber)) {
    	    	computerPickNums.add(randomNumber);
    	    }
    	}
    	return computerPickNums;
    }
    
}
