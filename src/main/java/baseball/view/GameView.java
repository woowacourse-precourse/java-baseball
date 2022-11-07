package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class GameView {
    private static final String OUTPUT_NEWLINE = "\n";
    public int inputToQuestion() {
        String input = Console.readLine();
        print(input);
        return inputValidate(input);
    }

    public int inputValidate(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void print(Object output) {
        System.out.print(output);
    }

    public void newLine(StringBuilder sb) {
        sb.append(OUTPUT_NEWLINE);
    }
}
