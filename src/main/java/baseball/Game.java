package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final PrintWindow printWindow;
    private Validator validator = new Validator();
    private final Computer computer;

    public Game(PrintWindow printWindow, Computer computer) {
        this.printWindow = printWindow;
        this.computer = computer;
        this.validator = validator;
    }

    public void gamePlay(){
        printWindow.startPrint();
        List<Integer> playerNum = new ArrayList<>();
        List<Integer> comNum = computer.getNumber();

        while (true){
            int strike = 0;
            int ball = 0;
            printWindow.playerTurnPrint();
            String userInput = Console.readLine();
            validator.isValidNumber(userInput);

            int[] result = Compare.excutue(comNum, userInput);
            strike = result[0];
            ball = result[1];


            if (ball==0 && strike==0){
                printWindow.resultNothingPrint();
                continue;
            }
            if (strike==3){
                printWindow.threeStrikePrint();
                strike =0;
                break;
            }
                printWindow.gameResult(ball,strike);

        }
    }
}
