package baseball;

import java.util.List;

public class ResultOutput {

    public static String resultString(List<Integer> resultList){
        int strike = resultList.get(0);
        int ball = resultList.get(1);

        if((strike == 0) && (ball == 0)){
            return "낫싱";
        }

        if((strike != 0) && (ball == 0)){
            return strike+"스트라이크";
        }

        if((strike == 0) && (ball != 0)){
            return ball+"볼";
        }

        return ball+"볼 "+strike+"스트라이크";
    }

}
