package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    List<Integer> targetNumber;

    public void generateTargetNumber() {
        while(targetNumber.size() < 3) {
            int randomNumber=Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        return inputStr;
    }
    public void compareWithTargetNum(String input) {
        int strikeCount=0;
        int ballCount=0;

        for(int order=0; order<3; order++){
            int targetDigit = targetNumber.get(order);
            int inputDigit = Integer.valueOf(input.charAt(order));

            if (targetDigit == inputDigit) {
                strikeCount++;
            } else if (input.contains(Integer.toString(targetDigit))) {
                ballCount++;
            }
        }
    }

    public void startGame() {
        // TODO: 타겟 넘버 생성, 사용자 입력 실행 등 새 게임 시작
    }
}
