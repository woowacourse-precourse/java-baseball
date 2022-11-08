package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현   
    	gameStart();
    }
    
    public static void gameStart() {
    	List<Integer> computerPickNums = computerPick();
    	List<Integer> playerPickNums = playerPick();
    	int strike = findStrike(computerPickNums, playerPickNums);
    	int ball = findball(computerPickNums, playerPickNums);
    	
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
    public static List<Integer> playerPick() {
    	List<Integer> playerPickNums = new ArrayList();
		int playerInput = Integer.parseInt(Console.readLine());
		if (playerInput<0 || playerInput>999) {
			// 에러 발생
		}
		int numOne = (int)(playerInput/100)%10;
		int numTwo = (int)(playerInput/10)%10;
		int numThree = playerInput%10;
		if(numOne == numTwo || numTwo == numOne || numThree == numOne || numOne == 0 || numTwo ==0 || numThree ==0) {
			// 에러발생
		}
		playerPickNums.add(numOne);
		playerPickNums.add(numTwo);
		playerPickNums.add(numThree);
		return playerPickNums;
    }
    public static void error() {
    	try {
    		throw new Exception("IllegalArgumentException");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public static int findStrike(List<Integer> computerPickNums, List<Integer> playerPickNums) {
    	int strike=0;
    	for(int i =0; i<3; i++) {
    		if(computerPickNums.get(i)==playerPickNums.get(i)) {
    			strike++;
    		}
    	}
    	return strike;
    }
    public static int findball(List<Integer> computerPickNums, List<Integer> playerPickNums) {
    	int ball=0;
    	if(playerPickNums.get(0)==playerPickNums.get(1)||playerPickNums.get(0)==playerPickNums.get(2)) {
    		ball++;
    	}
    	if(playerPickNums.get(1)==playerPickNums.get(2)||playerPickNums.get(1)==playerPickNums.get(0)) {
    		ball++;
    	}
    	if(playerPickNums.get(2)==playerPickNums.get(0)||playerPickNums.get(2)==playerPickNums.get(1)) {
    		ball++;
    	}
    	return ball;
    }
    
}
