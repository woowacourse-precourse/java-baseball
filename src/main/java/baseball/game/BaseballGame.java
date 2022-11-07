package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    private List<String> computerNumList;

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

    private void makeErrorCheckingInputSize(List<String> inputNumArray) {
        try {
            if (inputNumArray.size() > 3)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("세 자리 이상의 수를 입력하였습니다");
            System.exit(1);
        }
    }

    private void makeComputerNumList() {
        computerNumList = new ArrayList<>();
        while (computerNumList.size() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }
    }

    private int checkBall(List<String> inputNumList) {
        List<String> checkBallNumList = new ArrayList<>();
        checkBallNumList = inputNumList;
        checkBallNumList.retainAll(computerNumList);
        return checkBallNumList.size();
    }

    private int checkStrike(List<String> inputNumList) {
        int strikeNum = 0;
        if (checkBall(inputNumList) < 1) {
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
        if (inputNum.equals("1"))
            makeComputerNumList();
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

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int checkBall;
        int checkStrike;
        String receiveInput;
        List<String> inputNumList;
        makeComputerNumList();
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            receiveInput = receiveInput();
            inputNumList = makeInputNumList(receiveInput);
            makeErrorCheckingInputSize(inputNumList);
            checkBall = checkBall(inputNumList);
            checkStrike = checkStrike(inputNumList);
            showGameResult(checkStrike,checkBall);
            selectGameRestart(checkStrike);
        }
    }

}
