package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    List<Integer> targetNumber;
    protected boolean isPlayerWin=false;

    public void generateTargetNumber() {
        this.targetNumber = new ArrayList<>();
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
        checkInputLength(inputStr);
        checkInputNumber(inputStr);
        return inputStr;
    }

    public void checkInputLength(String inputStr) {
        if (inputStr.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력하세요.");
        }
    }

    public void checkInputNumber(String inputStr) {
        if ( (inputStr.charAt(0) == inputStr.charAt(1))
        || (inputStr.charAt(1) == inputStr.charAt(2))
        ||(inputStr.charAt(0) == inputStr.charAt(2))
        ) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력하세요.");
        }
    }

    public void compareWithTargetNum(String input) {
        int strikeCount=0;
        int ballCount=0;
        // System.out.println(targetNumber);


        for(int order=0; order<3; order++){
            int targetDigit = targetNumber.get(order);
            int inputDigit = input.charAt(order)-'0';

            if (targetDigit == inputDigit) {
                strikeCount++;
            } else if (input.contains(Integer.toString(targetDigit))) {
                ballCount++;
            }
        }
        printHint(strikeCount, ballCount);
    }

    public void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount > 0) { // 볼만 있는 경우
            System.out.print(ballCount+"볼\n");
        } else if (strikeCount > 0 && ballCount == 0) { // 스트라이크만 있는 경우
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
        restartGame();
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals('1')) {
            return true;
        } else if (input.equals('2')) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력하세요..");
        }
    }

    public void startGame() {
        generateTargetNumber();
        while(isPlayerWin==false){
            String newInput = getInput();
            compareWithTargetNum(newInput);
        }
    }
}
