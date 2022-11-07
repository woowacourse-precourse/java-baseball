package baseball;

import java.util.ArrayList;
import java.util.List;

public class RoundScore {
	public static List<Integer> score_list=new ArrayList<>();

	public static void addScoreAtUserInputNumber(int strike,int ball){
		score_list.add(strike);
		score_list.add(ball);
	}

	public static List<Integer> getScoreList(){
		return score_list;
	}
}
