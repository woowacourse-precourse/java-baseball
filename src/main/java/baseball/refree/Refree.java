package baseball.refree;

import java.util.Arrays;
import java.util.List;

public class Refree {
    private static int DEFAULT_ZERO = 0;
    private static String DEFAULT_BLANK = "";

    public static void compareToUserInput(String randomNumber, String input) {
        int strike = DEFAULT_ZERO;
        int ball = DEFAULT_ZERO;

        String[] inputList = input.split(DEFAULT_BLANK);
        List<String> randomNumberList = Arrays.asList(randomNumber.split(DEFAULT_BLANK));
        for (int i = 0; i < inputList.length; i++) {
            if (randomNumber.contains(inputList[i]) && (randomNumberList.indexOf(inputList[i]) == i)){
                strike++;
            } else if (randomNumber.contains(inputList[i]) && (randomNumberList.indexOf(inputList[i]) != i)){
                ball++;
            }
        }
        printResult(strike, ball);
    }

    private static void printResult(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println( ball + "볼 " + strike + "스트라이크 ");
        } else if (strike > 0 && ball == 0){
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0){
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }
}
