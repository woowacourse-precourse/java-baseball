package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {
    private static boolean isGameGoing = true;

    public static void gameStart() {
        Dealer dealer = new Dealer();
        Player player = new Player();
        List<Integer> dealerNumbers = dealer.createThreeDifferentNumbers();

        while (isGameGoing) {
            List<Integer> playerNumbers = player.createThreeDifferentNumbers();
            // calculator 스태틱으로 바꾸기
            Calculator calculator = new Calculator(dealerNumbers, playerNumbers);
            List<Integer> scores = calculator.getScores();
            ResultViewer.printOut(scores);
            checkThreeStrikes(scores.get(1));
        }
        gameShouldContinue();
    }

    public static void checkThreeStrikes(Integer strikeCount) {
        if (strikeCount == 3) {
            isGameGoing = false;
        }
    }

    public static void gameShouldContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerResponse = Console.readLine();
        checkResponseCode(playerResponse);
    }

    public static void checkResponseCode(String responseCode) {
        if (responseCode.equals("1")) {
            isGameGoing = true;
            gameStart();
        }
        if (!responseCode.equals("1") && !responseCode.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        gameStart();
    }
}
