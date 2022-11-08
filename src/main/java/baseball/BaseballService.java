package baseball;

import java.util.List;

public class BaseballService {

    private ComputerBaseball computerBaseball;

    public BaseballService(ComputerBaseball computerBaseball) {
        this.computerBaseball = computerBaseball;
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

    public void resetNumberList() {
        computerBaseball.resetNumberList();
    }
}
