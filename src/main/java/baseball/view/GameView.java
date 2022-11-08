package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class GameView {
    private static final String OUTPUT_NEWLINE = "\n";
    StringBuilder output;
    public int inputToQuestion() {
        output = new StringBuilder();
        String input = Console.readLine();
        outputBuilder(input);
        return inputValidate(input);
    }

    public void outputBuilder(String s) {//매개변수 이름 체크
        output = new StringBuilder();
        output.append(s);
        newLine();
        print();
    }

    public int inputValidate(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        try {
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    public void print() {
        System.out.print(output.toString());
    }

    public void newLine() {
        output.append(OUTPUT_NEWLINE);
    }
}
