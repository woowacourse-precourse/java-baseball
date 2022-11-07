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
        while(true) {
            int targetNumber = createTargetNumber();
            if (isValidNumber(targetNumber)) {
                break;
            }
        }

        // 3. 사용자로부터 서로 다른 세자리 수 받기
        int userInput = getUserInput();
        if (!isValidNumber(userInput)) {
            throw new IllegalArgumentException();
        }

        // 4. 스트라이크, 볼 개수 세기
        int strikeCnt = countStrikes(targetNumber, userInput);
        int ballCnt = countBalls(targetNumber, userInput);
        System.out.println(strikeCnt + "스트라이크");
        System.out.println(ballCnt + "볼");
    }

    private int createTargetNumber() {
        int newTarget = pickNumberInRange(1, 999);
        this.targetNumber = newTarget;
        return newTarget;
    }

    private int getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        int userInput = Integer.parseInt(readLine());
        return userInput;
    }

    private boolean isValidNumber(int num) {
        boolean invalidTF = true;

        // 한자리씩 분해하기
        List<Integer> checkArr = new ArrayList<>();
        while (num > 0) {
            checkArr.add(num % 10);
            num /= 10;
        }

        // HashSet을 통해 중복된 숫자 지우기
        HashSet<Integer> hashSet = new HashSet<>(checkArr);

        // 입력받은 숫자가 세자리가 아니거나, 세자리 수여도 서로 다른 숫자들이 아닐 경우
        if (checkArr.size() != 3 || hashSet.size() != 3) {
            invalidTF = false;
        }
        return invalidTF;
    }

    private int countStrikes(int targetNum, int inputNum) {
        List<Integer> targetNums = new ArrayList<>();
        while (targetNum > 0) {
            targetNums.add(targetNum % 10);
            targetNum /= 10;
        }

        List<Integer> inputNums = new ArrayList<>();
        while (inputNum > 0) {
            inputNums.add(inputNum % 10);
            inputNum /= 10;
        }

        int strikeCnt = 0;
        for (int i = 0; i < targetNums.size(); i++) {
            if (targetNums.get(i) == inputNums.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    private int countBalls(int targetNum, int inputNum) {
        List<Integer> targetNums = new ArrayList<>();
        while (targetNum > 0) {
            targetNums.add(targetNum % 10);
            targetNum /= 10;
        }

        List<Integer> inputNums = new ArrayList<>();
        while (inputNum > 0) {
            inputNums.add(inputNum % 10);
            inputNum /= 10;
        }

        int ballCnt = 0;
        for (int i = 0; i < targetNums.size(); i++) {
            if (targetNums.get(i) != inputNums.get(i) && targetNums.contains(inputNums.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}