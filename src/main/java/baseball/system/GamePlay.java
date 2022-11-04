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

        NumberComparison numberComparison = new NumberComparison(computer.getComputerNumbers());

        for(;;){

            printInputText();
            String inputNumber = inputUserNumbers();
            user.setUser(inputNumber);

            List<Integer> userNumbers = user.getUserNumbers();

            if(numberComparison.startComparison(userNumbers)){
                break;
            }
        }

        printGameEndText();

    }

    private String inputUserNumbers() {
        return Console.readLine();
    }

    private void printInputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printGameEndText(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
