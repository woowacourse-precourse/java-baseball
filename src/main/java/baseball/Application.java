package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현

	}

	public static List<Integer> computer() {
		List<Integer> computer = new ArrayList<Integer>();
		while (computer.size() < 3) {
			int RandomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(RandomNumber)) {
				computer.add(RandomNumber);
			}
		}
		return computer;
	}

	public static List<Integer> user() {
    	String userInput = Console.readLine(); 
    	String[] userInputArray = userInput.split("");
    	List<Integer> user = new ArrayList<Integer>();
    	for (int index = 0; index < userInputArray.length; index++) {
    		int digitNumber = Integer.parseInt(userInputArray[index]);
    		user.add(digitNumber);
    		if(!user.contains(digitNumber)) {
    			throw new IllegalArgumentException();
    		}
		}
    	if(user.size() != 3) {
    		throw new IllegalArgumentException();
    	}
		return user;
	}
}
