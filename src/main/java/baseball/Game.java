package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final PrintWindow printWindow;
    private Computer computer;

    public Game(PrintWindow printWindow) {
        this.printWindow = printWindow;
    }

    public void gamePlay(){
        printWindow.startPrint();
        List<Integer> playerNum = new ArrayList<>();
        List<Integer> comNum = computer.getNumber();
        int strike = 0;

        while (true){
            printWindow.playerTurnPrint();
            String userinput = Console.readLine();
            int ball = 0;

            for (int len = comNum.size(), i=0; i<len; i++){
                int play = userinput.charAt(i);

                if (comNum.indexOf(play) != i){
                    ball++;
                }
                if (comNum.indexOf(play)==i){
                    strike++;
                }
                if (comNum.indexOf(play) == -1){

                }
            }
            if (ball==0 && strike==0){
                printWindow.resultNothingPrint();
                continue;
            }if (strike==3){
                printWindow.threeStrikePrint();
                strike =0;
            }else {
                printWindow.gameResult(ball,strike);
            }
        }
    }
}
