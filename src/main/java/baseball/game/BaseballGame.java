package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    private String receiveInput() {
        String inputNum;
        inputNum = Console.readLine();
        return inputNum;
    }

    private List<String> makeInputNumList(String inputNum) {
        String[] inputNumArray = inputNum.split("");
        List<String> inputNumList = new ArrayList<>(Arrays.asList(inputNumArray));
        return inputNumList;
    }

    private void makeErrorCheckingInputSize(int[] inputNumArray) {
        try {
            if (inputNumArray.length > 3)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("세 자리 이상의 수를 입력하였습니다");
            System.exit(1);
        }
    }

    private List<String> makeComputerNumList() {
        List<String> computerNumList = new ArrayList<>();
        while (computerNumList.size() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }
        return computerNumList;
    }

    private int checkBall(List<String> inputNumList, List<String> computerNumList) {
        List<String> checkBallNumList = new ArrayList<>();
        checkBallNumList = inputNumList;
        checkBallNumList.retainAll(computerNumList);
        return checkBallNumList.size();
    }

    private int checkStrike(List<String> inputNumList, List<String> computerNumList) {
        int strikeNum = 0;
        if (checkBall(inputNumList, computerNumList) < 1) {
            return 0;
        }
        for (int i = 0; i < inputNumList.size(); i++) {
            if (inputNumList.get(i).equals(computerNumList.get(i))) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private void selectGameRestart(int strikeNum) {
        if (strikeNum != 3)
            return;
        String inputNum;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputNum = receiveInput();
        if (inputNum.equals("2"))
            System.exit(0);
    }

    private void showGameResult(int strikeNum, int ballNum) {
        if (strikeNum != 0 && ballNum != 0)
            System.out.println(ballNum + "볼" + " " + strikeNum + "스트라이크");
        if (strikeNum == 0 && ballNum != 0)
            System.out.println(ballNum + "볼");
        if (strikeNum == 3 && ballNum == 3)
            System.out.println(strikeNum + "스트라이크");
        if (strikeNum == 0 & ballNum == 0)
            System.out.println("낫싱");
    }
}
