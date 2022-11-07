package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Computer computer;
    Player player;

    public void startGame(int choice) {
        this.computer = new Computer();
        this.player = new Player();
        if (choice == 0) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            gameStart();
        } else if (choice == 1) {
            gameStart();
        }
    }

    private void gameStart() {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        //2. 3자리 랜덤 숫자 생성
        computer.createRandomNumber();
        while (result.get(1) != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            //3. 숫자 입력
            player.receiveInput();
            //4. 컴퓨터와 숫자 비교
            result = calculate(computer.RandomNumber, player.playerNumber);
            printResult(result);
        }
        //7. 재시작(1) or 종료(2) 그 외 IllegalArgumentException
        String input = Console.readLine();
        if (input.equals("1"))
            startGame(1);
    }

    private List<Integer> calculate(List<Integer> computer, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        result.add(findBall(computer, player));
        result.add(findStrike(computer, player));

        return result;
    }

    private int findStrike(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.get(index) == player.get(index)) {
                count++;
            }
        }
        return count;
    }

    private int findBall(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.get(index) != player.get(index) && computer.contains(player.get(index))) {
                count++;
            }
        }
        return count;
    }

    private void printResult(List<Integer> result) {
        int ball = result.get(0);
        int strike = result.get(1);
        StringBuilder stringBuilder = new StringBuilder();
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else {
            if (ball != 0 && strike != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball != 0) {
                System.out.println(ball + "볼");

            } else if (strike != 0) {
                System.out.println(strike + "스트라이크");
            }
        }
    }

}
