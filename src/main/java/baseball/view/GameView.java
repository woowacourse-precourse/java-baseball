package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class GameView {
    private static final String OUTPUT_NEWLINE = "\n";
    public int inputToQuestion() {
        int input = Integer.parseInt(Console.readLine());
        print(input);
        return input;
    }

    public void print(String output) {
        System.out.print(output);
    }

    public void print(int output) {
        System.out.print(output);
    }

    public void newLine(StringBuilder sb) {
        sb.append(OUTPUT_NEWLINE);
    }
}
