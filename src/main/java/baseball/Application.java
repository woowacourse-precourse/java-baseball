package baseball;
import java.util.ArrayList;
import java.util.List;

import baseball.HintMessage;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean game = true;
        boolean win = true;
        while (game) {
            HintMessage hint = new HintMessage();
            ComputerNumber computerNumber = new ComputerNumber();
            computerNumber.makeRandomNumber();
            List<Integer> com = computerNumber.getComputerNumber();
            for (Integer integer : com) {
                System.out.println("computerValue = " + integer);
            }

            UserNumber userNumber = null;
            userNumber = new UserNumber();
            List<Integer> user = null;
            do {
                userNumber.makeUserNumber();
                user = userNumber.getUserNumber();
                win = hint.checkPoint(user, com);
                hint.getHint();
            } while (win);
        }
    }
}
