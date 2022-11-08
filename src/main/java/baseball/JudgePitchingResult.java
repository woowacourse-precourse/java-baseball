package baseball;

import java.util.ArrayList;
import java.util.List;

public class JudgePitchingResult {
    int ball;
    int strike;

    public JudgePitchingResult(){
        this.ball = 0;
        this.strike = 0;
    }

    public List<Integer> returnPitchingResult(String input, List<Integer> computerNumberList){
        List<Integer> integerList = changeStringToIntegerList(input);
        for (int i =0; i<3; i++){
            int term = integerList.get(i);
            for (int j =0; j<3; j++){
                if(term == computerNumberList.get(j)){
                    if(i == j){
                        this.strike++;
                    }
                    else{
                        this.ball++;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(ball);
        result.add(strike);
        return result;
    }

    // 입력 정수값을 각 자리로 나누는 함수
    private List<Integer> changeStringToIntegerList(String inputString) {
        List<Integer> integerList = new ArrayList<>();

        String[] digits = inputString.split("(?<=.)");

        for (int i = 0; i < 3; i++) {
            integerList.add(Integer.valueOf(digits[i]));
        }
        return integerList;
    }


}
