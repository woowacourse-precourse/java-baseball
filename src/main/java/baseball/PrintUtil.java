package baseball;

import java.util.List;

public class PrintUtil {
    public void playGame() {
        RestartUtil restartUtil = new RestartUtil();
        PrintUtil printUtil = new PrintUtil();
        ArrayUtil arrayUtil = new ArrayUtil();
        InputUtil inputUtil = new InputUtil();
        List<Integer> randomNumber = arrayUtil.createRandomNumber();
        boolean end = false;
        printUtil.inputGame(end, randomNumber);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartUtil.restartGame(inputUtil.restartQuestion());
    }
    public void startApplication() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.playGame();
    }
    public void inputGame(boolean end, List<Integer> randomNumber) {
        CountUtil countUtil = new CountUtil();
        ArrayUtil arrayUtil = new ArrayUtil();
        InputUtil inputUtil = new InputUtil();
        while (!end) {
            System.out.print("숫자를 입력해주세요 : ");
            end = countUtil.compareNumber(arrayUtil.arrayPlayerNumber(inputUtil.inputPlayerNumber()), randomNumber);
        }
    }
    public boolean printBallStrike(List<Integer> countBallStrike) {
        CountUtil countUtil = new CountUtil();
        boolean end = countUtil.endGame(countBallStrike);
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