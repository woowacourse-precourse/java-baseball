package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    List<Integer> targetNumber;
    protected boolean isPlayerWin=false;
    protected boolean isLastGame=true;

    public void generateTargetNumber() {
        this.targetNumber = new ArrayList<>();
        while(targetNumber.size() < 3) {
            int randomNumber=Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
    }

    public void compareWithTargetNum(String input) {
        int strikeCount=0;
        int ballCount=0;
        System.out.println(targetNumber);


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

    public void restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            isLastGame=false;
        } else if (input.equals("2")) {
            isLastGame=true;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력하세요..");
        }
    }

    public void startGame() {
        generateTargetNumber();
        while(isPlayerWin==false){
            String newInput = Input.getUserNumber();
            compareWithTargetNum(newInput);
        }
    }
}
