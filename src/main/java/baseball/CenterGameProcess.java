package baseball;

import java.util.List;

public class CenterGameProcess {
    OutputSentense output = new OutputSentense();
    GameReferee count = new GameReferee();

    public CenterGameProcess(List<Integer> computer, int gameTypeNumber) {

        String myNumber = output.Question(output.inputNumber, gameTypeNumber);
        List<Integer> myNumberList = output.InputNumberList(myNumber);

    }
}
