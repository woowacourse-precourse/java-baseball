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
        isAnswer = gameInfo.isEnd();
    }

    private void printInit() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void getRandomNumbers() {
        while (computer.size() < LEN) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }

    private boolean isValidNumber() {
        if (user.length() != LEN) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            if (!Character.isDigit(user.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        user = Console.readLine();
    }

    private void compareNumber() {
        for (int i = 0; i < LEN; i++) {
            int loc = computer.indexOf(user.charAt(i) - '0');
            if (loc == i) {
                gameInfo.addStrike();
            }
            else if (loc >= 0) {
                gameInfo.addBall();
            }
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
        printInit();
        getRandomNumbers();

        while (!isAnswer) {
            gameInfo = new GameInfo();
            readNumbers();
            if (!isValidNumber()) {
                throw new IllegalArgumentException("");
            }
            compareNumber();
            printResult();
            isAnswer = gameInfo.isAnswer();
            if (isAnswer) {
                printEnd();
            }
        }
    }


}
