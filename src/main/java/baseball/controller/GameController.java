package baseball.controller;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import baseball.model.Computer;

public class GameController {

    Computer computer = new Computer();

    public void startNewGame() {

        // 1. 컴퓨터가 서로 다른 세자리 수 생성하기
        computer.setTargetDigits();
        List<Integer> targetDigits = computer.getTargetDigits();

        // 2. 사용자가 숫자를 모두 맞출때까지 계속 숫자 입력받기
        while (true) {

            // 2-1. 사용자로부터 서로 다른 세자리 수 받기
            System.out.print("숫자를 입력해주세요 : ");
            int userInput = Integer.parseInt(Console.readLine());


            List<Integer> userInputDigits = decomposeNumber(userInput);
            if (!isValidNumber(userInputDigits)) {
                throw new IllegalArgumentException();
            }

            // 2-2. 받은 숫자의 스트라이크, 볼 개수 세기
            int[] strikesAndBalls = computer.countStrikesAndBalls(targetDigits, userInputDigits);
            int strikes = strikesAndBalls[0];
            int balls = strikesAndBalls[1];
            System.out.println(computer.makeInfoString(strikes, balls));

            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }

    public boolean restart() {
        boolean restartTF;
        int answer = Integer.parseInt(Console.readLine());
        if (answer == 1) {
            restartTF = true;
        } else if (answer == 2) {
            restartTF = false;
        } else {
            throw new IllegalArgumentException();
        }
        return restartTF;
    }

    private boolean isValidNumber(List<Integer> digitList) {
        boolean invalidTF = true;
        HashSet<Integer> digitSet = new HashSet<>(digitList);

        // 입력받은 숫자가 세자리가 아니거나, 세자리 수여도 서로 다른 숫자들이 아닐 경우
        if (digitList.size() != 3 || digitSet.size() != 3) {
            invalidTF = false;
        }
        return invalidTF;
    }

    private List<Integer> decomposeNumber(int num) {
        List<Integer> digitList = new ArrayList<>();
        while (num > 0) {
              digitList.add(0, num % 10);
            num /= 10;
        }
        return digitList;
    }

}