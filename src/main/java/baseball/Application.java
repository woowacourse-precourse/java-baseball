package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		playGame();
	}
	
	private static void playGame() {
		String message = "숫자 야구 게임을 시작합니다.";
		System.out.println(message);
		
		computerPickNumber();
		
		while(true) {
			userInputNumber();
			if(pitcherNumberList.size() == 0) {
				return;
			}
			
			message = roundResult().toString();
			System.out.println(message);
			
			if(message.equals("3스트라이크")) {
				message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
				System.out.println(message);
				break;
			}
		}
		
		selectGameStart();
	}
	
	private static void selectGameStart() {
		String message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		System.out.println(message);
		String select = Console.readLine();
		
		if(select.equals("1")) {
			playGame();
			return;
		}
		
		if(select.equals("2")) {
			return;
		}
		
		throwException();
		return;
	}

	private static List<Integer> batterNumberList;
	private static List<Integer> pitcherNumberList;

	private static void computerPickNumber() {
		batterNumberList = new ArrayList<>();

		while(batterNumberList.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);

			if(!batterNumberList.contains(randomNumber)) {
				batterNumberList.add(randomNumber);
			}
		}
		System.out.println(batterNumberList);
	}

	private static void userInputNumber() {
		pitcherNumberList = new ArrayList<>();
		
		String message = "숫자를 입력해주세요 : ";
		System.out.print(message);
		String userInput = Console.readLine();
		
		if(!validateCheck(userInput)) {
			throwException();
			return;
		}
		
		for(int i = 0; i < userInput.length(); i++) {
			pitcherNumberList.add(userInput.charAt(i) - 48);
		}
	}

	private static boolean validateCheck(String userInput) {
		if(userInput.length() != 3) {
			return false;
		}

		Set<Character> userInputSet = new HashSet<>();

		for(int i = 0; i < userInput.length(); i++) {
			char inputCharacter = userInput.charAt(i);
			
			if(inputCharacter < 49 || 57 < inputCharacter) {
				return false;
			}
			
			userInputSet.add(userInput.charAt(i));
		}

		if(userInputSet.size() != 3) {
			return false;
		}
		return true;
	}
	
	private static void throwException() {
		throw new IllegalArgumentException();
	}

	private static StringBuilder roundResult() {
		StringBuilder builder = new StringBuilder();
		
		int strikeCount = 0, ballCount = 0;
		
		for(int i = 0; i < batterNumberList.size(); i++) {
			if(pitcherNumberList.get(i) == batterNumberList.get(i)) {
				strikeCount++;
				continue;
			}
			
			if(pitcherNumberList.contains(batterNumberList.get(i))) {
				ballCount++;
				continue;
			}
		}
		
		if(strikeCount == 0 && ballCount == 0) {
			builder.append("낫싱");
			return builder;
		}
		
		if(ballCount != 0) {
			builder.append(ballCount + "볼");
		}
		
		if(strikeCount != 0) {
			if(builder.length() != 0) {
				builder.append(" ");
			}
			
			builder.append(strikeCount + "스트라이크");
		}
		
		return builder;
	}
	
}