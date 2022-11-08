package baseball;

import java.util.List;

import static baseball.Parsing.splitString;
import static baseball.printConsoleMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        int strike = 0;
        int ball = 0;
        String flag;
        List<Integer> COM = Randomizing.getRandomNumber();
        printStart();
        while (true) {
            printInput();
            String N = readLine();
            if (N.length() != 3) {
                throw new IllegalArgumentException();
            }
            List<Integer> M = splitString(N);
            for (int i = 0; i < 3; i++) {
                if (COM.get(i).equals(M.get(i))) {
                    strike++;
                } else if (M.contains(COM.get(i))) {
                    ball++;
                }
            }
            printScore(strike, ball);

            if (strike == 3) {
                printResult();
                flag = readLine();
                if (flag.equals("2")) {
                    break;
                } else if (!flag.equals("1")) {
                    throw new IllegalArgumentException();
                } else {
                    COM = Randomizing.getRandomNumber();
                }
            }
            strike = 0;
            ball = 0;
        }
    }
}
