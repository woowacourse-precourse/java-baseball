package baseball;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberScore {
    public static Map<String, Integer> numberCount(int userNumber, List<Integer> randomList, int loopFrequency) {

        int[] userList = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
        // List<Integer> userList=Arrays.stream(arrNum).boxed().collect(Collectors.toList());

        int strike = 0;
        int ball = 0;
        for (int i = 0; i <= loopFrequency; i++) {
            if (userList[i] == randomList.get(i)){
                strike +=1;
            } else if (randomList.contains(userList[i])) {
                ball +=1;
            }
        }
        Map<String, Integer> result= new HashMap<>();
        result.put("strike", strike);
        result.put("ball", ball);
        return result;
    }
}
