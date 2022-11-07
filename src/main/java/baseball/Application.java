package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> playerNumber() {
        List<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        while (player.size() < 3) {
            int playerIdx = 0;
            //잘못 입력한 경우에 대한 예외처리 기능 구현해야 함
            char inputNumber = input.charAt(playerIdx);
            int inputNumberToInt = inputNumber - '0';
            player.add(inputNumberToInt);
            playerIdx++;
        }
        return player;
    }

    public static int findStrike(List<Integer> computer, List<Integer> player) {
        int strikeNumber = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (computer.get(idx) == player.get(idx)) {
                strikeNumber++;
            }
        }
        return strikeNumber;
    }

    public static int findBall(List<Integer> computer, List<Integer> player) {
        int ballNumber = 0;
        for (int computerIdx = 0; computerIdx < 3; computerIdx++) {
            for (int playerIdx = 0; playerIdx < 3; playerIdx++) {
                if ((computerIdx != playerIdx) && (computer.get(computerIdx) == player.get(playerIdx))) {
                    ballNumber++;
                }
            }
        }
        return ballNumber;
    }

    public static void compare(List<Integer> computer, List<Integer> player) {
        int strikeNumber = findStrike(computer, player);
        int ballNumber = findBall(computer, player);

        if (strikeNumber != 0) {
            System.out.print(strikeNumber + "스트라이크 ");
        }
        if (ballNumber != 0) {
            System.out.print(ballNumber + "볼 ");
        }
        if (strikeNumber == 0 && ballNumber == 0) {
            System.out.print("낫싱");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        compare(computerNumber(), playerNumber());
    }
}
