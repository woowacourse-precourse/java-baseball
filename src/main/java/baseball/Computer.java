package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int LIST_SIZE = 3;

    private List<Integer> random_num_list = new ArrayList<>();
    private RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

    public void computer_random_num() {
        random_num_list = randomNumGenerator.randomNumGenerator(LIST_SIZE, START_RANGE, END_RANGE);
    }
    public List<Integer> getRandomNumList() {
        return random_num_list;
    }
}
