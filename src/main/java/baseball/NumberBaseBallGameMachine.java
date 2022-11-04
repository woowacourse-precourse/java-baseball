package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallGameMachine {
    Referee referee = new Referee();
    NumberMaker numberMaker = new NumberMaker();

    public void display(String message) {
        System.out.print(message);
    }

    public String getInputLine() {
        return Console.readLine();
    }

    public void makeNewAnswer() {
        referee.setAnswer(numberMaker.makeThreeDifferentNumberListInRange(1, 9));
    }
}
