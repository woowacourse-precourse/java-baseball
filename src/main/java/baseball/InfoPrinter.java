package baseball;

import java.util.List;

public class InfoPrinter {
    private InfoPrinter() {
    }

    public static void printStrikesAndBalls(List<Integer> strikesAndBalls) {
        int strikes = strikesAndBalls.get(0);
        int balls = strikesAndBalls.get(1);
        String result = "";

        if (balls != 0) {
            result += String.format("%d볼 ", balls);
        }
        if (strikes != 0) {
            result += String.format("%d스트라이크", strikes);
        }
        if (result.length() == 0) {
            System.out.println("낫싱");
        }
        System.out.println(result.trim());
    }
}
