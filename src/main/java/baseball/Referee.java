package baseball;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {
    public static void refereeResult() {
        resultPrint(count(Computer.computerNumber(), User.inputUserNumber()));
    }
    public static void resultPrint(List<Integer> result) {
        List<Integer> strike = Collections.singletonList(result.get(1));
        List<Integer> ball = Collections.singletonList(result.get(2));
         if (strike.contains(0) && ball.contains(0)) {
             System.out.println("낫싱");
         } else if (strike.contains(0)) {
             System.out.println(ball + "볼");
         } else if (ball.contains(0)) {
             System.out.println(strike + "스트라이크");
         }
         System.out.println(strike + "스트라이크" + ball + "볼");
         if (strike.contains(3)) {
             System.out.println("숫자를 모두 맞히셨습니다! 축하합니다!");
         } else User.inputUserNumber();
    }

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
