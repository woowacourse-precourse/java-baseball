package baseball;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RoundScore {
	public static HashMap<String,Integer> score_map=new LinkedHashMap<>();
	public static void addScoreAtUserInputNumber(int STRIKE,int BALL){
		score_map.put("STRIKE",STRIKE);
		score_map.put("BALL",BALL);
	}

	public static HashMap<String,Integer> getScoreMap(){
		CompareNumber.setInitializeScore();
		return score_map;
	}

}
