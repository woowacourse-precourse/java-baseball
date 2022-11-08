package baseball.domain.user;

import baseball.domain.input.ConsoleInputReader;

import java.util.List;

public class Player {
    private List<Integer> numberList;

    public void enterNumberList() {
        numberList = ConsoleInputReader.getUserNumberList();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
