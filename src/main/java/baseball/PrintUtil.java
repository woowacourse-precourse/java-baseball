package baseball;

import java.util.List;

public class PrintUtil {
    public static void inputGame(boolean end, List<Integer> randomNumber) {
        ArrayUtil arrayUtil = new ArrayUtil();
        InputUtil inputUtil = new InputUtil();
        while (!end) {
            System.out.print("숫자를 입력해주세요 : ");
            end = arrayUtil.compareNumber(arrayUtil.arrayPlayerNumber(inputUtil.inputPlayerNumber()), randomNumber);
        }
    }
    public boolean printBallStrike(List<Integer> countBallStrike) {
        boolean end = endGame(countBallStrike);
        if (countBallStrike.get(0) == 0 && countBallStrike.get(1) == 0)
            System.out.println("낫싱");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(0) + "볼 " + countBallStrike.get(1) + "스트라이크");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) == 0)
            System.out.println(countBallStrike.get(0) + "볼");
        else if (countBallStrike.get(0) == 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(1) + "스트라이크");
        return end;
    }
}