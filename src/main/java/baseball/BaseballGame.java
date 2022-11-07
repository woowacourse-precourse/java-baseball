package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    List<Integer> targetNumber;
    private boolean isPlayerWin=false;

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
        printHint(strikeCount, ballCount);
    }

    public void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount != 0) { // 볼만 있는 경우
            System.out.print(ballCount+"볼\n");
        } else if (strikeCount != 0 && ballCount == 0) { // 스트라이크만 있는 경우
            System.out.print(strikeCount+"스트라이크\n");
        } else if (strikeCount == 0 && ballCount == 0) { // 낫싱
            System.out.print("낫싱\n");
        } else { // 볼, 스트라이크 모두 있는 경우
            System.out.print(ballCount + "볼 " + strikeCount + "스트라이크\n");
        }
        if (strikeCount==3) {
            endGame();
        }
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        isPlayerWin=true;
    }

    public void startGame() {
        generateTargetNumber();
        while(isPlayerWin==false){
            String newInput = getInput();
            compareWithTargetNum(newInput);
        }
    }
}
