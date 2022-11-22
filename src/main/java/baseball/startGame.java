package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;

public class startGame {

    public static int makegameStartEnd() {
        List<Integer> newAnswerNumber = answerNumber.makeAnswerNumber();
        String getNum = getNumber.makeGetNumber();
        Scanner in = new Scanner(System.in);
        int returnNumber = 0;

        while (true) {

            List<Integer> newInputNumber = null;
            try {
                newInputNumber = inputNumber.makeInputNumber(getNum);
            } catch (IllegalArgumentException e) {
                throw e;
            }

            if(baseball.printCase.makePrintCase(newAnswerNumber, newInputNumber)) {
                String num = Console.readLine();
                int chooseNumber = Integer.parseInt(num);

                if(chooseNumber == 1) {
                    returnNumber = 1;
                    break;
                } else {
                    returnNumber = 2;
                    break;
                }
            }

        }
        return returnNumber;
    }
}
