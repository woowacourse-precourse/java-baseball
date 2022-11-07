package baseball;

import java.util.List;

public class PrintUtil {
    public void startApplication() {
        CountUtil countUtil = new CountUtil();
        System.out.println("숫자 야구 게임을 시작합니다.");
        countUtil.playGame();
    }
    public void inputGame(List<Integer> randomNumber) {
        boolean end = false;
        while (!end) {
            System.out.print("숫자를 입력해주세요 : ");
            end = printBallStrike(randomNumber);
        }
    }
    public boolean printBallStrike(List<Integer> randomNumber) {
        CountUtil countUtil = new CountUtil();
        boolean end = false;
        List<Integer> compareNumber = countUtil.compareNumber(randomNumber);
        if (compareNumber.get(1) == 3) {
            end = true;
            System.out.println("3스트라이크");
        }
        else if (compareNumber.get(0) == 0 && compareNumber.get(1) == 0)
            System.out.println("낫싱");
        else if (compareNumber.get(0) != 0 && compareNumber.get(1) != 0)
            System.out.println(compareNumber.get(0) + "볼 " + compareNumber.get(1) + "스트라이크");
        else if (compareNumber.get(0) != 0 && compareNumber.get(1) == 0)
            System.out.println(compareNumber.get(0) + "볼");
        else if (compareNumber.get(0) == 0 && compareNumber.get(1) != 0)
            System.out.println(compareNumber.get(1) + "스트라이크");
        return end;
    }
}