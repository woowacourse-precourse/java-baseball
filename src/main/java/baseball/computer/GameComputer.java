package baseball.computer;

import java.util.List;

public interface GameComputer {
    void autoSetNumbers();

    String printHintForInput(List<Integer> input);

    boolean isNotGameEndCase(List<Integer> input);

    boolean isNumberGenerated(int size);
}


