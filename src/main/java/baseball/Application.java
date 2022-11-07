package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	RandomNumberFactory randomNumberFactory = new RandomNumberFactory();
    	InputValidation inputValidation = new InputValidation();
    	Distinguisher inputDistinguisher = new Distinguisher();
        
    	List<Integer> randomNumber = randomNumberFactory.createRamdomNumbers(1, 9, 3);
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	while(true) {
    		System.out.println("숫자를 입력해주세요 : ");
        	String input = Console.readLine();
        	
        	if(!inputValidation.isValidRandomNumbers(input)) {
        		throw new IllegalArgumentException("잘못된 입력 값입니다.");
        	}
        	
        	String output = inputDistinguisher.distinguish(randomNumber, input);
        	System.out.println(output);
        	
        	if(!output.equals("3스트라이크")) {
        		continue;
        	}
        	
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		input = Console.readLine();
    		
    		if(!inputValidation.isValidReStart(input)) {
        		throw new IllegalArgumentException("잘못된 입력 값입니다.");
        	}
    		if(input.equals("2")) {
    			break;
    		}
    		randomNumber = randomNumberFactory.createRamdomNumbers(1, 9, 3);
    	}
    }
    
}
