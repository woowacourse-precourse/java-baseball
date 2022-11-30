package baseball.controller;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public enum Separator {
    SEPARATOR;

    private List<Character> separator;

    public List<Character> execute() {
        separator = new ArrayList<>();
        String readLine = new InputView().putReadLine();
        return separate(readLine);
    }

    private List<Character> separate(String readLine) {

        readLine.chars()
                .mapToObj(element -> (char) element)
                .forEach(separator::add);
        return separator;
    }
}
