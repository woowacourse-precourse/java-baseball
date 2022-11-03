package baseball.system;

import baseball.player.*;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class GamePlay {

    private Computer computer;
    private User user;

    GamePlay(Computer computer , User user){
        this.computer = computer;
        this.user = user;
    }

    public void playGame(){

        NumberComparison numberComparison = new NumberComparison();

        for(;;){

            printInputText();
            String inputNumber = inputUserNumber();
            user.setUser(inputNumber);

            List<Integer> computerNumbers = computer.getComputerNumberList();
            List<Integer> userNumbers = user.getUserNumberList();

            if(numberComparison.startComparison(computerNumbers,userNumbers)){
                break;
            }
        }

    }

    private String inputUserNumber() {
        return Console.readLine();
    }

    private void printInputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }


}
