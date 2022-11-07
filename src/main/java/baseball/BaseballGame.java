package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseballGame {

    private int targetNumber;

    void startNewGame() {

        // 1. 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 2. 컴퓨터가 서로 다른 세자리 수 생성하기
        while (true) {
            int targetNumber = createTargetNumber();
            if (isValidNumber(targetNumber)) {
                break;
            }
        }

        // 3. 사용자가 숫자를 모두 맞출때까지 계속 숫자 입력받기
        boolean gotAnswer = false;
        int userInput;

        while (!gotAnswer) {

            // 3-1. 사용자로부터 서로 다른 세자리 수 받기
            userInput = getUserInput();
            if (!isValidNumber(userInput)) {
                throw new IllegalArgumentException();
            }

            // 3-2. 받은 숫자의 스트라이크, 볼 개수 세기
            int strikeCnt = countStrikes(targetNumber, userInput);
            int ballCnt = countBalls(targetNumber, userInput);
            String cntInfo = buildCntInfo(strikeCnt, ballCnt);
            System.out.println(cntInfo);

            if (strikeCnt == 3) {
                gotAnswer = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

    boolean doesRestart() {
        boolean restartTF;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = Integer.parseInt(readLine());
        if (answer == 1) {
            restartTF = true;
        } else if (answer == 2) {
            restartTF = false;
        } else {
            throw new IllegalArgumentException();
        }
        return restartTF;
    }

    private int createTargetNumber() {
        int newTarget = pickNumberInRange(1, 999);
        this.targetNumber = newTarget;
        return newTarget;
    }

    private int getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        int inputNumber = Integer.parseInt(readLine());
        return inputNumber;
    }

    private boolean isValidNumber(int num) {
        boolean invalidTF = true;

        List<Integer> digitList = decomposeNumber(num);
        HashSet<Integer> digitSet = new HashSet<>(digitList);

        // 입력받은 숫자가 세자리가 아니거나, 세자리 수여도 서로 다른 숫자들이 아닐 경우
        if (digitList.size() != 3 || digitSet.size() != 3) {
            invalidTF = false;
        }
        return invalidTF;
    }

    private int countStrikes(int targetNum, int inputNum) {

        List<Integer> targetDigits = decomposeNumber(targetNum);
        List<Integer> inputDigits = decomposeNumber(inputNum);

        int strikeCnt = 0;
        for (int i = 0; i < targetDigits.size(); i++) {
            if (targetDigits.get(i) == inputDigits.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private int countBalls(int targetNum, int inputNum) {

        List<Integer> targetDigits = decomposeNumber(targetNum);
        List<Integer> inputDigits = decomposeNumber(inputNum);

        int ballCnt = 0;
        for (int i = 0; i < targetDigits.size(); i++) {
            if (targetDigits.get(i) != inputDigits.get(i) && targetDigits.contains(inputDigits.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    private List<Integer> decomposeNumber(int num) {
        List<Integer> digitList = new ArrayList<>();
        while (num > 0) {
            digitList.add(num % 10);
            num /= 10;
        }
        return digitList;
    }

    private String buildCntInfo(int strikeCnt, int ballCnt) {
        String info = "";

        if (ballCnt > 0 && strikeCnt > 0) {
            info = ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if (ballCnt > 0) {
            info = ballCnt + "볼";
        } else if (strikeCnt > 0) {
            info = strikeCnt + "스트라이크";
        } else {
            info = "낫싱";
        }

        return info;
    }
}