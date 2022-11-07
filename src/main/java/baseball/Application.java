package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    final static int RESTART = 1;
    final static int GAME_OVER = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {

            Domain domain = new Domain();
            List<Integer> computerNumber = domain.getComputerNumber();
            playGame(computerNumber, domain);

            int userDecision = getUserDecision();
            if (isGameOver(userDecision, RESTART, GAME_OVER)) {
                break;
            }
        }

    }

    public static void playGame(List<Integer> computerNumber, Domain domain) {
        while (true) {
            System.out.print("숫자를 입력하세요 : ");
            List<Integer> userNumberList = domain.getUserNumber();
            Game game = new Game(computerNumber, userNumberList);
            int countStrike = game.play();
            if (isStrikeThree(countStrike)) {
                break;
            }
        }
    }

    private static boolean isStrikeThree(int countStrike) {
        return countStrike == 3;
    }

    public static Integer getUserDecision() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer user_decision = Integer.parseInt(Console.readLine());

        return user_decision;
    }

    public static boolean isGameOver(int userDecision, int RESTART,
        int GAME_OVER) {
        if (userDecision == GAME_OVER) {
            return true;
        } else if (userDecision == RESTART) {
            return false;
        } else {
            throw new IllegalArgumentException("사용자 결정 오류");
        }
    }


}
