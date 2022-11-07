package baseball.service;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class UserService {

    private final User user;
    private String userBaseballNumber;

    public UserService(User user) {
        this.user = user;
    }

    public void inputBaseballNumber() {
        userBaseballNumber = Console.readLine();
        user.setBaseballNumber(userBaseballNumber);
    }

    public String setBaseballNumber() {
        return user.getBaseballNumber();
    }
}
