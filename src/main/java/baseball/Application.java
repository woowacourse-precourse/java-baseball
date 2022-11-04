package baseball;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import baseball.HintMessage;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean game = true;
        boolean win = true;
        HintMessage hint = new HintMessage();
        while (game) {
            ComputerNumber computerNumber = new ComputerNumber();
            computerNumber.makeRandomNumber();
            List<Integer> com = computerNumber.getComputerNumber();
            for (Integer integer : com) {
                System.out.print("computerValue = " + integer + " ");
            }
            System.out.println();

            UserNumber userNumber = null;
            List<Integer> user = null;
            do {
                userNumber = new UserNumber();
                userNumber.makeUserNumber();
                user = userNumber.getUserNumber();
//                game = hint.checkPoint(user, com);
                win = hint.checkPoint(user, com);
            } while (win);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int inputNumber = Integer.parseInt(Console.readLine());
            if (inputNumber == 1) {
                game = true;
            }
            if (inputNumber == 2) {
                game = false;
            }
        }
    }
}
