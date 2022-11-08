package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {
	
	public void randomNumbers() {
		List<Integer> randomNumList = randomNumber();
	}
	
	public List<Integer> randomNumber(){
		List<Integer> numberList = new ArrayList<>();
		while (numberList.size() < 3) {
	        int randomNumber = Randoms.pickNumberInRange(1,9);
	        if (!numberList.contains(randomNumber)) {
	            numberList.add(randomNumber);
	        }
	    }
		return numberList;
	}
}