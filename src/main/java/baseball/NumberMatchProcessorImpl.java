package baseball;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberMatchProcessorImpl implements NumberMatchProcessor{

    @Override
    public List<Integer> compare(int gameNum, int userNum) {

        List<Integer> result = new ArrayList<>(List.of(0, 0));


        List<String> gameNumList = Stream.of(String.valueOf(gameNum).split(""))
                .collect(Collectors.toList());
        List<String> userNumList = Stream.of(String.valueOf(userNum).split(""))
                .collect(Collectors.toList());


        int strike = 0;
        int ball = 0;
        for (int i=0; i<3; i++) {
            //스트라이크
            if (gameNumList.get(i).equals(userNumList.get(i)))strike++;
            //볼
            else if (gameNumList.contains(userNumList.get(i))) ball++;
        }

        result.set(0, strike);
        result.set(1, ball);

        return result;
    }


    @Override
    public String printHint(List<Integer> targetList) {
        return null;
    }
}
