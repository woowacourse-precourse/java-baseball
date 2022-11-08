package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Integer> input = new ArrayList<>();

    public void setInput(List<Integer> input) {
        this.input = input;
    }

    public void log() {
        input.forEach(System.out::println);
        System.out.println("===");
    }
}
