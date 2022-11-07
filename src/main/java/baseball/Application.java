package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		String user_input_number = Console.readLine();
		try{
			Validation.validation("user_input_number_validation",user_input_number);

			List<Integer> random_number_list = RandomNumber.createRandomNumber();

			CompareNumber.compareUserNumberAndRandomNumber(user_input_number,random_number_list);

			List<Integer> score_ist = RoundScore.getScoreList();
			System.out.println(random_number_list);
			scoreConsoleOutput(score_ist);
		}catch (IllegalArgumentException e){
			return;
		}
	}


	private static void scoreConsoleOutput(List<Integer> score_list){
		int strike_score = score_list.get(0);
		int ball_score = score_list.get(1);
		if (strike_score==0&&ball_score==0) {
			System.out.println("낫싱");
		}
		else {
			System.out.println(ball_score+"볼 "+strike_score+"스트라이크");
		}
	}
}
