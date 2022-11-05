package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballService {

    private View view;
    private ComputerBaseball computerBaseball;

    public BaseballService(View view, ComputerBaseball computerBaseball) {
        this.view = view;
        this.computerBaseball = computerBaseball;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {

        }
    }

    private List<Integer> createBaseballNumberList() {
        String baseballNumber = getBaseballNumber();
        return Stream.of(baseballNumber.split(""))
                     .map(Integer::parseInt)
                     .collect(Collectors.toCollection(ArrayList::new));
    }

    private String  getBaseballNumber() {
        String baseballNumber = view.inputBaseballNumber();
        validateBaseballNumber(baseballNumber);
        return baseballNumber;
    }
    private void validateBaseballNumber(String baseballNumber) {
        if (baseballNumber.length() > 3) {
            throw new IllegalArgumentException();
        }
    }
}
