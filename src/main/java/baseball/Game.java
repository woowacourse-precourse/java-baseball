package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    List<Integer> opponentNumList = new ArrayList<>();
    List<Integer> inputNumList = new ArrayList<>();
    int strike;
    int ball;

    Game() {
        startPhrase();
        opponentNumber();
    }

    private void opponentNumber() {
        int tmpNum;
        for (int i = 0; i < 3; i++) {
            opponentNumList.add(Randoms.pickNumberInRange(1, 9));
            if (sameNumber(i, opponentNumList)) {
                opponentNumList.remove(i);
                i--;
            }
        }
    }

    public boolean sameNumber(int nowListIndex, List<Integer> opponentNum) {
        for (int i = 0; i < opponentNum.size(); i++) {
            if (i == nowListIndex) {
                continue;
            }
            if (Objects.equals(opponentNum.get(i), opponentNum.get(nowListIndex))) {
                return true;
            }
        }
        return false;
    }

    public void startPhrase() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        exceptionHandling(inputNum);
    }

    public void exceptionHandling(String inputNum) {
        if (!checkingDifferentNumber(inputNum) || !lengthTree(inputNum)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean lengthTree(String inputNum) {
        return inputNum.length() == 3;
    }

    public boolean checkingDifferentNumber(String num) {
        eachFindDigits(num);
        for (int i = 0; i < inputNumList.size(); i++) {
            if (sameNumber(i, inputNumList)) {
                return false;
            }
        }
        return true;
    }

    public void eachFindDigits(String num) {
        int numLength = num.length();
        for (int i = 0; i < numLength; i++) {
            inputNumList.add(num.charAt(i) - '0');
        }
    }

    private boolean gameResults() {
        Result result = new Result(strike, ball);
        return result.success();
    }

    private void initInputNumValue() {
        inputNumList.clear();
    }

    private void gameHint() {
        Hint hint = new Hint(opponentNumList, inputNumList);
        hint.checkHint();
        strike = hint.strike;
        ball = hint.ball;
    }

    public void start() {
        while (true) {
            initInputNumValue();
            inputNumber();
            gameHint();
            if (gameResults()) {
                break;
            }
        }
        RestartOrFinish selectRestartOrFinish = new RestartOrFinish();
        selectRestartOrFinish.finishGame();
    }

}