package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;

public class startGame {

    public static int makegameStartEnd() {
        List<Integer> newAnswerNumber = answerNumber.makeAnswerNumber();
        Scanner in = new Scanner(System.in);
        int returnNumber = 0;

        while (true) {

            List<Integer> newInputNumber = null;
            try {
                newInputNumber = inputNumber.makeInputNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }

            if(baseball.printCase.makePrintCase(newAnswerNumber, newInputNumber)) {
//                int chooseNumber = in.nextInt();
                String num = Console.readLine();
                int chooseNumber = Integer.parseInt(num);

                if(chooseNumber == 1) {
                    returnNumber = 1;
                    break;
                } else {
                    returnNumber = 2;
                    System.out.println("게임종료");
                    break;
                }
            }

        }
        return returnNumber;
    }
}
