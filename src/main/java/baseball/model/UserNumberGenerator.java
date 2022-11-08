package baseball.model;

import baseball.view.InputView;

import java.util.List;

public class UserNumberGenerator {

    public final List<Integer> VALIDATED_NUM;

    public UserNumberGenerator() {
        this.VALIDATED_NUM = generateUserNum();
    }


}
