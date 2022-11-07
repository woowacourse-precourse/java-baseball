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
        int targetNumber = createTargetNumber();

        // 2. 사용자에게 숫자 받기
        getUserInput();
    }

    private int createTargetNumber() {
        int newTarget = pickNumberInRange(1, 999);
        this.targetNumber = newTarget;
        return newTarget;
    }

    private void getUserInput() {

        // 1. 숫자 입력받기
        System.out.println("숫자를 입력해주세요 : ");
        int userInput = Integer.parseInt(readLine());

        // 1-1. 입력받은 숫자 유효성 검사
        if (!isInvalidNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidNumber(int num) {
        boolean invalidTF = true;

        // 한자리씩 배열에 넣기
        List<Integer> checkArr = new ArrayList<>();
        while (num > 0) {
            checkArr.add(num % 10);
            num /= 10;
        }
        HashSet<Integer> hashSet = new HashSet<>(checkArr);

        // 입력받은 숫자가 세자리가 아니거나, 세자리 수여도 서로 다른 숫자들이 아닐 경우
        if (checkArr.size() != 3 || hashSet.size() != 3) {
            invalidTF = false;
        }
        return invalidTF;
    }
}