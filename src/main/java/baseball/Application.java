package baseball;

import static baseball.GameRules.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static UserPlayer userPlayer;
	private static BaseballGameModel baseballGameModel;
	private static boolean gameStatus;

	public static void main(String[] args) {
		String userInput;
		List<Integer> scoreList;

		System.out.println("숫자 야구 게임을 시작합니다.");
		gameInit();

		while (gameStatus) {
			System.out.print("숫자를 입력해주세요 : ");
			userInput = Console.readLine();

			try {
				isValidUserInput(userInput);
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				return;
			}
			userPlayer.setNumberList(userInput);

			scoreList = baseballGameModel.getMatchResult();

			if (baseballGameModel.isGameOver()) {
				System.out.println(DIGIT_NUMBER.getCode()+"스트라이크");
				System.out.println(DIGIT_NUMBER.getCode()+"개의 숫자를 모두 맞히셨습니다! 게임 종료");

				try {
					choiceGameProgress();
				} catch (IllegalArgumentException e){
					System.out.println(e.getMessage());
					return;
				}
				continue;
			}
			printMatchResult(scoreList);
		}

    }

	public static void gameInit() {
		ComputerPlayer computerPlayer = new ComputerPlayer();
		userPlayer = UserPlayer.getInstance();
		baseballGameModel = new BaseballGameModel(computerPlayer);
		gameStatus = true;
	}

	public static void choiceGameProgress() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String gameProgressNumber = Console.readLine();

		isValidProgressNumber(gameProgressNumber);

		if (Integer.parseInt(gameProgressNumber) == GAME_END.getCode()) {
			gameStatus = false;
			System.out.println("게임을 진짜 종료합니다.");
			return;
		}

		System.out.println("새로운 게임을 시작합니다.");
		gameInit();
	}

	public static void printMatchResult(List<Integer> scoreList) {
		if (scoreList.isEmpty()) {
			System.out.println("낫싱");
			return;
		}

		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i) == 0) {
				continue;
			}
			if (i == 0) {
				System.out.print(scoreList.get(i)+"볼 ");
				continue;
			}
			System.out.println(scoreList.get(i)+"스트라이크");
		}
		System.out.println();
	}

	public static void isValidUserInput(String userInput) {
		isOnlyNumber(userInput);
		isDigitNumber(userInput);
		isDifferentNumber(userInput);
	}

	public static void isValidProgressNumber(String userInput) {
		isOnlyNumber(userInput);
		isCorrectNumber(userInput);
	}

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

	public static void isCorrectNumber(String userInput) throws IllegalArgumentException {
		int UserNumber = Integer.parseInt(userInput);
		if (!GAME_RESTART.getCode().equals(UserNumber) && !GAME_END.getCode().equals(UserNumber)) {
			throw new IllegalArgumentException(
				"게임 재시작(" + GAME_RESTART.getCode() + ") 또는 " + "게임종료(" + GAME_END.getCode() + ") 만 입력가능합니다.");
		}
	}
}
