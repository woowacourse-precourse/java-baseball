package baseball;

import static baseball.GameRules.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static ComputerPlayer computerPlayer;
	private static List<Integer> userPlayer;

    public static void main(String[] args) {
		computerPlayer = new ComputerPlayer();

        // TODO: 프로그램 구현
		/*
		컴퓨터플레이어 클래스
		숫자야구 게임모델 클래스
			- 매개변수로 넘어온 입력값 판단
			- 예외처리.. 어디서 처리?
		어플리케이션 : 사용자 입력 & 화면 처리
			- 입력 게임모델클래스에 넘겨줌
		* */
		String userInput = Console.readLine();


		try {
			isOnlyNumber(userInput);
			isDigitNumber(userInput);
			isDifferentNumber(userInput);
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			return;
		}

		userPlayer = setUserPlayer(userInput);

		System.out.println("userPlayer = " + userPlayer);
		System.out.println("프로그램 끝");

    }

	/*public static boolean isValidUserInput(String userInput) {
		try {
			isOnlyNumber(userInput);
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			return true;
		}
		return false;

	}*/

	public static void isOnlyNumber(String userInput) throws IllegalArgumentException{
		final Pattern numberOnly = Pattern.compile("^[1-9]*?");
		boolean number = numberOnly.matcher(userInput).matches();

		if (!number) {
			throw new IllegalArgumentException("입력값은 숫자로만 이루어져야합니다.");
		}
	}

	public static void isDigitNumber(String userInput) throws IllegalArgumentException {
		if (userInput.length() != DIGIT_NUMBER.getCode()) {
			throw new IllegalArgumentException(DIGIT_NUMBER.getCode() + "개의 수를 입력해야합니다.");
		}
	}

	public static void isDifferentNumber(String userInput) throws IllegalArgumentException{
		String[] userInputArray = userInput.split("");

		List<Integer> userNumersList = Arrays.stream(userInputArray)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		if (userNumersList.size() != userNumersList.stream().distinct().count()) {
			throw new IllegalArgumentException("서로다른 수를 입력해아합니다.");
		}
	}

	public static List<Integer> setUserPlayer(String userInput){
		String[] userInputArray = userInput.split("");
		return Arrays.stream(userInputArray)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
