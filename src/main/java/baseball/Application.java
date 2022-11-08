package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static boolean RESTART = false;
    public static boolean FINISH = false;

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
        for (int idx = 0; idx < computer.size(); idx++) {
            if ((computer.get(idx) != player.get(idx)) && (computer.indexOf(player.get(idx)) != -1)) {
                ballNumber++;
            }
        }
        return ballNumber;
    }

    public static void restart(Computer computer) {
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();

        if (input.equals("1")) {
            RESTART = true;
        }
        else if (input.equals("2")) {
            FINISH = true;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public static void playStart(Computer computer, Player player) {
        int strikeNumber = findStrike(computer.getComputerNumber(), player.getPlayerNumber());
        int ballNumber = findBall(computer.getComputerNumber(), player.getPlayerNumber());

        if (ballNumber != 0) {
            System.out.print(ballNumber + "볼 ");
        }
        if (strikeNumber != 0) {
            System.out.print(strikeNumber + "스트라이크 ");
            if (strikeNumber == 3) {
                restart(computer);
                return;
            }
        }
        if (strikeNumber == 0 && ballNumber == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.makeRandom();
        Player player = new Player();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            player.makePlayerNumber();
            playStart(computer, player);

            if (RESTART == true) {
                computer.makeRandom();
                RESTART = false;
            }
            else if (FINISH == true) {
                break;
            }
        }
    }
}
