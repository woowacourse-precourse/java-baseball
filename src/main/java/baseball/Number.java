package baseball;

import java.util.List;

public interface Number {
    int MAX_SIZE = 3;
    int START_NUMBER = 1;
    int END_NUMBER = 9;

    void create();
    List<Integer> get();
}
