package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Round {

    private Computer computer;
    private Numbers numbers;

    public Round(Computer computer) {
        this.computer = computer;
        startNewRound();
    }

    private void startNewRound() {
        Print.printRoundStart();
        String inputString = Console.readLine();
        inputNewNumbers(inputString);
    }

    private void inputNewNumbers(String inputString) {
        int input = Integer.parseInt(inputString);
        numbers = new Numbers(input);
    }
}
