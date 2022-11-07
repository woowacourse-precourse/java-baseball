package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
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
        System.out.println("숫자 야구 게임을 시작합니다");
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
        String pattern = "^[0-9]*$"; // 숫자만 등장하는지
        if (baseballNumber.length() > 3) {
            throw new IllegalArgumentException("3자리 정수를 입력해야합니다.");
        }
        if (!Pattern.matches(pattern, baseballNumber)){
            throw new IllegalArgumentException("정수만 포함되어야 합니다.");
        }
            hasDuplicateNumbers(baseballNumber);

    }

    private void hasDuplicateNumbers(String baseballNumber) {
        long count = Arrays.stream(baseballNumber.split(""))
                           .distinct()
                           .count();
        if (count != 3) {
            throw new IllegalArgumentException("서로 다른 정수를 입력해야 합니다.");
        }

    }
}
