package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        playGame();
    }

    private static List<Integer> pickComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void checkPlayerInput(String line) {
        if (line == null || line.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (line.charAt(0) == line.charAt(1) || line.charAt(0) == line.charAt(2) || line.charAt(1) == line.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        checkPlayerInput(line);

        List<Integer> player = new ArrayList<>();
        for (String s : line.split("")) {
            player.add(Integer.parseInt(s));
        }
        return player;
    }

    private static boolean printHint(List<Integer> computer, List<Integer> player) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike == 3) {
            System.out.println("3스트라이크");
            return true;
        } else if (ball == 0) {
            System.out.printf("%d스트라이크%n", strike);
        } else if (strike == 0) {
            System.out.printf("%d볼%n", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
        }
        return false;
    }

    public static void checkNewGameInput(String line) {
        if (!line.equals("1") && !line.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    private static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = pickComputerNumber();
        while (true) {
            List<Integer> player = inputPlayerNumber();
            boolean result = printHint(computer, player);

            if (result) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String line = Console.readLine();

        checkNewGameInput(line);

        if (line.equals("1")) {
            playGame();
        } else {
            System.out.println("게임 종료");
        }
    }
}
