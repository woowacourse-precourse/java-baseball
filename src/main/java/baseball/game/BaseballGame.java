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


}
