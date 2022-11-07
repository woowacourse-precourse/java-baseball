package baseball;

import camp.nextstep.edu.missionutils.Console;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int threeStrike = 0;

    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while (threeStrike == 0) {
            System.out.print("숫자를 입력해 주세요 : ");
            String player = Console.readLine();
            baseballGame(computer, player);
        }

    }

    private static void baseballGame(List<Integer> computer, String player) {
        int ball = 0;
        int strike = 0;

        if (computer.toString().charAt(1) == player.charAt(0)) strike++;
        if (computer.toString().charAt(4) == player.charAt(1)) strike++;
        if (computer.toString().charAt(7) == player.charAt(2)) strike++;

        if (computer.toString().charAt(1) == player.charAt(1) || computer.toString().charAt(1) == player.charAt(2))
            ball++;
        if (computer.toString().charAt(4) == player.charAt(0) || computer.toString().charAt(4) == player.charAt(2))
            ball++;
        if (computer.toString().charAt(7) == player.charAt(0) || computer.toString().charAt(7) == player.charAt(1))
            ball++;

        if (strike == 0 && ball == 0) {
            System.out.println("낫씽");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike == 3) {
            threeStrike = 1;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}





