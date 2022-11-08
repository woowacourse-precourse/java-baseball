package baseball;

import static baseball.GameRules.*;

import java.util.List;

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

		// while문 -> playGame 매소드로
		// Gameprogress 매소드로 짖속여부
		// 1-> playGame 다시호출
		// 2-> 완전 끝

		while (gameStatus) {
			System.out.print("숫자를 입력해주세요 : ");
			userInput = Console.readLine();

			try {
				UserInputValidator.isValidUserInput(userInput);
				// isValidUserInput(userInput);
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				return;
			}
			userPlayer.setNumberList(userInput);

			scoreList = baseballGameModel.getMatchResult();

			if (baseballGameModel.isGameOver()) {
				System.out.println(DIGIT_NUMBER.getCode()+"스트라이크");
				System.out.println(DIGIT_NUMBER.getCode()+"개의 숫자를 모두 맞히셨습니다! 게임 종료");


				choiceGameProgress();

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

	// public static void playGame() {
	// 	String userInput;
	// 	List<Integer> scoreList;
	//
	// 	while (gameStatus) {
	// 		System.out.print("숫자를 입력해주세요 : ");
	// 		userInput = Console.readLine();
	//
	// 		try {
	// 			UserInputValidator.isValidUserInput(userInput);
	// 			// isValidUserInput(userInput);
	// 		} catch (IllegalArgumentException e){
	// 			System.out.println(e.getMessage());
	// 			return;
	// 		}
	// 		userPlayer.setNumberList(userInput);
	//
	// 		scoreList = baseballGameModel.getMatchResult();
	//
	// 		if (baseballGameModel.isGameOver()) {
	// 			System.out.println(DIGIT_NUMBER.getCode()+"스트라이크");
	// 			System.out.println(DIGIT_NUMBER.getCode()+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
	//
	//
	// 			choiceGameProgress();
	//
	// 			try {
	// 				choiceGameProgress();
	// 			} catch (IllegalArgumentException e){
	// 				System.out.println(e.getMessage());
	// 				return;
	// 			}
	// 			continue;
	// 		}
	//
	// 		printMatchResult(scoreList);
	// 	}
	// }

	public static void gameInit() {
		ComputerPlayer computerPlayer = new ComputerPlayer();
		userPlayer = UserPlayer.getInstance();
		baseballGameModel = new BaseballGameModel(computerPlayer);
		gameStatus = true;
	}

	public static void choiceGameProgress() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String gameProgressNumber = Console.readLine();

		// isValidProgressNumber(gameProgressNumber);
		UserInputValidator.isValidProgressNumber(gameProgressNumber);

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
}
