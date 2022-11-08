package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	private static int COIN;
	private static List<Integer> random_number_list = new ArrayList<>();

	public static void startPlayBaseBall() {
		baseBall();
	}

	private static void baseBall() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		random_number_list = RandomNumber.createRandomNumber();
		System.out.println("random_number_list = " + random_number_list);
		COIN = 1;
		while (COIN == 1) {

			System.out.print("숫자를 입력해주세요 : ");
			String user_input_number = Console.readLine();

			if (!Validation.validation("user_input_number_validation", user_input_number)
					||
					!Validation.validation("user_input_not_duplication_number", user_input_number)) {
				throw new IllegalArgumentException("It's wrong input number value");
			}

			CompareNumber.compareUserNumberAndRandomNumber(user_input_number, random_number_list);
			HashMap<String, Integer> score_map = RoundScore.getScoreMap();
			scoreConsoleOutput(score_map);
		}
	}





	public static void scoreConsoleOutput(HashMap<String,Integer>score_map){
		int strike_score = score_map.get("STRIKE");
		int ball_score = score_map.get("BALL");
		if (strike_score==0&&ball_score==0) {
			System.out.println("낫싱");
		}
		else if(strike_score==3){
			scoreConsoleOutputAtAllStrike(strike_score);
		}
		else {
			System.out.println(ball_score+"볼 "+strike_score+"스트라이크");
		}
	}

	public static void scoreConsoleOutputAtAllStrike(int strike_score){
		System.out.println(strike_score+"스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		reTryCondition();
	}

	private static void reTryCondition(){
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String user_retry_condition = Console.readLine();
		if(Validation.validation("user_retry_condition_validation",
				user_retry_condition)) {
			throw new IllegalArgumentException("It's wrong retry condition value");
		}
		random_number_list=RandomNumber.createRandomNumber();
		COIN = Integer.parseInt(user_retry_condition);
	}
}
