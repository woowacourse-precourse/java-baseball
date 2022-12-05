package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public enum Separator {
    SEPARATOR;

    private List<Character> separator;

    public List<Character> execute(String readLine) {
        separator = new ArrayList<>();
        return separate(readLine);
    }

    private List<Character> separate(String readLine) {

        readLine.chars()
                .mapToObj(element -> (char) element)
                .forEach(separator::add);
        return separator;

    }
}
