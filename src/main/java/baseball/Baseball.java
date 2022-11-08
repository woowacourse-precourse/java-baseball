package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Baseball {
    static final int LEN = 3;
    private final List<Integer> computer;
    private GameInfo gameInfo;
    private String user;

    private boolean isAnswer;

    public Baseball() {
        computer = new ArrayList<>();
        gameInfo = new GameInfo();
        user = "";
        isAnswer = gameInfo.isAnswer();
    }

    private void addNumberToList(int randomNum) {
        if (!computer.contains(randomNum)) {
            computer.add(randomNum);
        }
    }

    private void getRandomNumbers() {
        while (computer.size() < LEN) {
            addNumberToList(Randoms.pickNumberInRange(1, 9));
        }
    }

    private boolean isAllDigit() {
        boolean result = true;

        for (int i = 0; i < LEN && result; i++) {
            result = Character.isDigit(user.charAt(i));
        }
        return result;
    }

    private void CheckValidNumber() {
        if (user.length() != LEN) {
            throw new IllegalArgumentException("");
        }
        else if (!isAllDigit()) {
            throw new IllegalArgumentException("");
        }
    }

    private void readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        user = Console.readLine();
    }

    private void setResult(int comIdx, int userIdx) {
        if (comIdx == userIdx) {
            gameInfo.addStrike();
        }
        else if (comIdx >= 0) {
            gameInfo.addBall();
        }
    }

    private void compareNumber() {
        for (int i = 0; i < LEN; i++) {
            setResult(computer.indexOf(user.charAt(i) - '0'), i);
        }
    }

    private void printResult() {
        String result = gameInfo.getResultString();
        System.out.println(result);
    }

    private void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void gameStart() {
        getRandomNumbers();

        while (!isAnswer) {
            gameInfo = new GameInfo();
            readNumbers();
            CheckValidNumber();
            compareNumber();
            printResult();
            isAnswer = gameInfo.isAnswer();
        }
        printEnd();
    }


}
