package baseball.view;

import baseball.model.Computer;
import baseball.model.Player;

import static baseball.Constants.OutputMessage.END_MESSAGE;

public class OutputView {

    public void printGameEnd(){
        System.out.println(END_MESSAGE);
    }
    public void printHint(String hint){
        System.out.println(hint);
    }
}
