package baseball.view;

import static baseball.constValue.Constants.OutputMessage.END_MESSAGE;

public class OutputView {

    public void printGameEnd(){
        System.out.println(END_MESSAGE);
    }
    public void printHint(String hint){
        System.out.println(hint);
    }
}
