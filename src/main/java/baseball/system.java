package baseball;
import java.util.ArrayList;
import java.util.List;

public class system {
    public static List<Integer> count(List<Integer> computerBaseballNumber, List<Integer> userNumber){
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (computerBaseballNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            } else if (computerBaseballNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
        result.add(strikeCount);
        result.add(ballCount);
        return result;
    }
}
