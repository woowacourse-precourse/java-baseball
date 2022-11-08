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
            String userinput = Console.readLine();
            validator.isValidNumber(userinput);

            for (int len = comNum.size(), i=0; i<len; i++){
                int play = userinput.charAt(i)-'0';

                if (comNum.indexOf(play) == -1){
                    ball--;
                }
                if (comNum.indexOf(play) != i){
                    ball++;
                }
                if (comNum.indexOf(play)==i){
                    strike++;
                }
            }
            System.out.println(userinput);
            System.out.println(comNum);
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
