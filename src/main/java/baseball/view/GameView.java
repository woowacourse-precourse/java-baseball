package baseball.view;

import camp.nextstep.edu.missionutils.Console;
public class GameView {
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
}
