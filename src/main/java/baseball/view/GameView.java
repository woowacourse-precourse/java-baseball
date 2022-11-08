package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class GameView {
    private static final String OUTPUT_NEWLINE = "\n";
    private static final String EXCEPTION_MESSAGE_NOT_NUMBER = "숫자가 아닌 값을 입력하셨습니다.";
    private static final String EXCEPTION_MESSAGE_NOT_INPUT = "입력값이 없습니다.";
    StringBuilder output;
    public int inputToQuestion() {
        output = new StringBuilder();
        String input = Console.readLine();
        outputBuilder(input);
        return inputValidate(input);
    }

    public void outputBuilder(String addString) {
        output = new StringBuilder();
        output.append(addString);
        newLine();
        print();
    }

    public int inputValidate(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_INPUT);
        }
        try {
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_NUMBER);
        }
    }

    public void print() {
        System.out.print(output.toString());
    }

    public void newLine() {
        output.append(OUTPUT_NEWLINE);
    }
}
