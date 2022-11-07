package baseball;

import java.util.List;

import baseball.view.InputView;

public class Application {

    private static final InputView INPUT_VIEW = new InputView();

    public static void main(String[] args) {
        List<Integer> userNumbers = INPUT_VIEW.promptNumbers();
    }
}
