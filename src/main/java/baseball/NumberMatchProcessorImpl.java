package baseball;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberMatchProcessorImpl implements NumberMatchProcessor{

    @Override
    public List<Integer> compare(List<Integer> gameNum, List<Integer> userNum) {

        List<Integer> result = new ArrayList<>(List.of(0, 0));

        int strike = 0;
        int ball = 0;
        for (int i=0; i<3; i++) {
            //스트라이크
            if (gameNum.get(i).equals(userNum.get(i)))strike++;
            //볼
            else if (gameNum.contains(userNum.get(i))) ball++;
        }

        result.set(0, strike);
        result.set(1, ball);

        return result;
    }


    @Override
    public String printHint(List<Integer> targetList) {
        if (targetList.get(0)==0 & targetList.get(1)==0) return "낫싱";
        if (targetList.get(0)==0) return targetList.get(1)+"볼";
        if (targetList.get(1)==0) return targetList.get(0)+"스트라이크";
        return targetList.get(1)+"볼"+" "+targetList.get(0)+"스트라이크";
    }
}
