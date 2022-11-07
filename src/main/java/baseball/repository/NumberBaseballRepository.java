package baseball.repository;

import baseball.domain.ComputerNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballRepository {
    private static final int LIMIT_NUMBER = 10;
    private static final int START_NUMBER = 1;
    private static final int LIMIT_PICK_COUNT = 3;
    private static final int COMPUTER_NUMBER = 0;

    private static final NumberBaseballRepository instance = new NumberBaseballRepository();
    private static final List<ComputerNumber> numberStore = new ArrayList<>();

    private NumberBaseballRepository() {
    }

    public static NumberBaseballRepository getInstance() {
        return instance;
    }

    public ComputerNumber generateComputerNumber() {
        clearNumberStore();
        List<Integer> pickNumberList = new ArrayList<>();
        while (pickNumberList.size() < LIMIT_PICK_COUNT) {
            int pickNumber = Randoms.pickNumberInRange(START_NUMBER, LIMIT_NUMBER);
            if (!pickNumberList.contains(pickNumber)) {
                pickNumberList.add(pickNumber);
            }
        }
        numberStore.add(new ComputerNumber(pickNumberList));
        return numberStore.get(COMPUTER_NUMBER);
    }

    public void clearNumberStore() {
        numberStore.clear();
    }

    public ComputerNumber findComputerNumber() {
        return numberStore.get(COMPUTER_NUMBER);
    }
}
