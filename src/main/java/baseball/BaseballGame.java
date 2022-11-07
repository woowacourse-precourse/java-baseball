package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGame {
    private final View view;
    private final BaseballService baseballService;

    public BaseballGame(View view, BaseballService baseballService) {
        this.view = view;
        this.baseballService = baseballService;
    }

    public void start() {
        System.out.println("게임시작");
        while (true) {
            List<Integer> baseballNumberList = createBaseballNumberList();
            BaseBallDto result = baseballService.getResult(baseballNumberList);
            view.printBaseBallResult(result);
            //3스트라이크 체크 후 다음 동작
        }
    }

    private List<Integer> createBaseballNumberList() {
        String baseballNumber = inputUserNumbers();
        return Stream.of(baseballNumber.split(""))
                     .map(Integer::parseInt)
                     .collect(Collectors.toCollection(ArrayList::new));
    }

    private String inputUserNumbers() {
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
