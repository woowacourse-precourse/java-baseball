package baseball;

import java.util.List;

public class CenterGameProcess {
    OutputSentense output = new OutputSentense();
    GameReferee count = new GameReferee();

    public CenterGameProcess(List<Integer> computer, int gameTypeNumber) {

        while (true) {
            String myNumber = output.Question(output.inputNumber, gameTypeNumber);
            List<Integer> myNumberList = output.InputNumberList(myNumber);
            int countStrike = count.Strike(myNumberList, computer);
            int countBall = count.Ball(myNumberList, computer);
            output.showMessage(output.scoreBoard(countStrike, countBall));
            if (countStrike == computer.size()) {
                output.showMessage(output.ending);
                break;
            }
        }
    }
}
