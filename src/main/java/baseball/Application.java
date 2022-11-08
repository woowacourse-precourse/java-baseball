package baseball;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int threeStrike = 0;

    public static void main(String[] args) {
        newGame("1");

    }

    private static void newGame(String gameStart) {
        if (gameStart.equals("1")) {
            baseballStart();
        }
        if (gameStart.equals("2")) {
            System.out.println("종료");
        }
    }

    private static void baseballStart() {
        List<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        threeStrike = 0;

        while (threeStrike == 0) {
            System.out.print("숫자를 입력해 주세요 : ");
            String player = Console.readLine();
            if (player.length() != 3) {
                throw new IllegalArgumentException();
            }
            baseballCount(computer, player);
        }
    }


    private static void baseballCount(List<Integer> computer, String player) {
        int ball = 0;
        int strike = 0;

        if (computer.toString().charAt(1) == player.charAt(0)) strike++;
        if (computer.toString().charAt(4) == player.charAt(1)) strike++;
        if (computer.toString().charAt(7) == player.charAt(2)) strike++;

        if (computer.toString().charAt(1) == player.charAt(1) || computer.toString().charAt(1) == player.charAt(2))
            ball++;
        if (computer.toString().charAt(4) == player.charAt(0) || computer.toString().charAt(4) == player.charAt(2))
            ball++;
        if (computer.toString().charAt(7) == player.charAt(0) || computer.toString().charAt(7) == player.charAt(1)) {
            ball++;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        }

        if (strike == 3) {
            threeStrike = 1;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameStart = Console.readLine();
            newGame(gameStart);
        }
    }
}




