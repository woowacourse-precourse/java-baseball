package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Controller {
    public static void start() {
        boolean isGameGoing = true;

        Dealer dealer = new Dealer();
        Player player = new Player();
        List<Integer> dealerNumbers = dealer.createThreeDifferentNumbers();

        while (isGameGoing) {
            List<Integer> playerNumbers = player.createThreeDifferentNumbers();
            // calculator 스태틱으로 바꾸기
            Calculator calculator = new Calculator(dealerNumbers, playerNumbers);
            List<Integer> scores = calculator.getScores();
            ResultViewer.printOut(scores);

            // checkThreeStrikes
            if (scores.get(1) == 3) {
                isGameGoing = false;
            }
        }

        // shouldContinue
        System.out.println("계속 고?");
        String yesOrNo = Console.readLine();
        if (yesOrNo.equals("1")) {
            start();
        }
    }
}
