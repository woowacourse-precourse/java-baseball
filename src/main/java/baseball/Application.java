package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	
	public static void main(String[] args) {
    	String message = "";
    	Boolean again = true;
    	while(again) {
    		int total = 0, strike = 0 ,ball = 0;
    		List<Integer> computer = ComputerRandomMake();
    		System.out.println(computer);
    		while(strike != 3) {
    			System.out.println("숫자 3자리를 입력하세요~");
    			List<Integer> userInput = userInputList();
    			total = totalMatch(computer,userInput);
    			strike = strike(computer,userInput);
    			ball = total - strike;	
    			message = message(strike, ball);
    			System.out.println(message);
    		}
    		again = againGame();
    	}
    	System.out.println("게임 종료");
    }
    
    // 컴퓨터 랜덤 숫자 만들기
    public static int RandomNum() {
    	int Randomnum = Randoms.pickNumberInRange(1, 9);
    	return Randomnum;
    }
    
    // 리스트 배열에 랜덤 숫자 추가
    public static List<Integer> ComputerRandomMake(){
    	List<Integer> computerNum = new ArrayList<>();
    	while(computerNum.size() < 3) {
    		int random = RandomNum();
    		if(computerNum.contains(random)) {
    			continue;
    		} else {
    			computerNum.add(random);    			
    		}
    		int n =1;
    		int a =1;
    		Math.ceil(n/a);
    	}
    	return computerNum;
    }
    
    // 사용자 입력받은 값 리스트 담기
    public static List<Integer> userInputList() {
    	List<Integer> userInputList = new ArrayList<>();
    	int userInput = Integer.parseInt(Console.readLine());
    	verifyInput(userInput);
    	userInputList = IntStream.of(inputToList(userInput)).boxed().collect(Collectors.toList());
    	return userInputList;
    }
    
    // 사용자 입력받은 값 리스트로 변환
    public static int [] inputToList(int userInput){
    	int[] userInputList = Stream.of(String.valueOf(userInput).split("")).mapToInt(Integer::parseInt).toArray();
    	return userInputList;
    }
    
    // 자리 상관없이 일치하는 값의 갯수
    public static int totalMatch(List<Integer> computer, List<Integer> userInput) {
    	int total = 0;
    	for(int i= 0 ; i < 3 ; i++) {
    		if(computer.contains(userInput.get(i))) total ++;
    	}
    	return total;
    }
    
    // 자리와 일치하는 값의 갯수
    public static int strike(List<Integer> computer, List<Integer> userInput) {
    	int strike = 0;
    	for(int i = 0 ; i < 3 ; i++) {
    		if(computer.get(i).equals(userInput.get(i))) strike++;
    	}
    	return strike;
    }
    
    // 해당 메세지 출력
    public static String message(int strike, int ball) {
    	String message = "";
    	if(ball != 0 && strike != 0) {
    		message = ball + "볼 " + strike + "스트라이크";
    	} else if(ball != 0) {
    		message = ball + "볼";
    	} else if(strike != 0) {
    		message = strike + "스트라이크";
    	} else message = "낫싱";
    	
    	return message;
    }
    
    // 다시할지 선택하기
    public static Boolean againGame() {
    	Boolean again = true;
    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    	int againNum = Integer.parseInt(Console.readLine());
    	
    	if(againNum == 2) {
    		again = false;
    	} else {
    		again = true;
    	}
    	return again;
    }
    
    // 예외 테스트
    public static void verifyInput(int userInput) {
    	String user = Integer.toString(userInput);
    	if(user.length() != 3) throw new IllegalArgumentException("Invaild input length");
    }
}
