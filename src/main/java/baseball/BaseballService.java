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

    public BaseBallDto getResult(List<Integer> userBaseballNumberList) {
        int ball = getBall(userBaseballNumberList);
        int strike = getStrike(userBaseballNumberList);
        ball -= strike;
        return new BaseBallDto(strike, ball);

    }

    private int getBall(List<Integer> userBaseballNumberList) {
        List<Integer> baseballNumberList = computerBaseball.getNumberList();
        return (int) userBaseballNumberList.stream()
                                           .filter(baseballNumberList::contains)
                                           .count();
    }

    private int getStrike(List<Integer> userBaseballNumberList) {
        List<Integer> computerBaseballNumberList = computerBaseball.getNumberList();
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            Integer computerNumber = computerBaseballNumberList.get(i);
            Integer userNumber = userBaseballNumberList.get(i);
            if (computerNumber.equals(userNumber)) {
                strike++;
            }
        }
        return strike;
    }
    private List<Integer> createBaseballNumberList() {
        String baseballNumber = getBaseballNumber();
        System.out.println(baseballNumber);
        return Stream.of(baseballNumber.split(""))
                     .map(Integer::parseInt)
                     .collect(Collectors.toCollection(ArrayList::new));
    }

    private String getBaseballNumber() {
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
