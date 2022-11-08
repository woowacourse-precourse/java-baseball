package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    private List<Integer> computerNumList;

    public void makeComputerNumList() {
        computerNumList = new ArrayList<>();
        while (computerNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }
    }

    private int checkBall(List<Integer> inputNumList) {
        int ballNum = 0;
        List<Integer> checkBallNumList = new ArrayList<>();
        checkBallNumList.addAll(inputNumList);
        checkBallNumList.retainAll(computerNumList);
        ballNum = checkBallNumList.size();
        return ballNum;
    }

    private int checkStrike(List<Integer> inputNumList) {
        int strikeNum = 0;
        for (int i = 0; i < inputNumList.size(); i++) {
            if (inputNumList.get(i) == computerNumList.get(i)) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private void selectGameRestart(int strikeNum) {
        if (strikeNum != 3)
            return;
        String inputNum;
        BaseballInput baseballInput = new BaseballInput();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputNum = baseballInput.receiveInput();
        if (inputNum.equals("2"))
            System.exit(0);
        if (inputNum.equals("1"))
            makeComputerNumList();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballInput baseballInput = new BaseballInput();
        BaseballResult baseballResult = new BaseballResult();
        makeComputerNumList();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            baseballInput.userInputGame();
            baseballResult.ballNum = checkBall(baseballInput.inputNumList);
            baseballResult.strikeNum = checkStrike(baseballInput.inputNumList);
            baseballResult.showGameResult();
            selectGameRestart(baseballResult.strikeNum);
        }
    }
}
