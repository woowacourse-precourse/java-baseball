package baseball.service;

import baseball.domain.User;

public class UserService {
    private final User user;

    public UserService(User user) {
        this.user = user;
    }

    public void inputBaseballNumber() {
        user.inputBaseballNumber();

        if (!user.isValidNumber())
            throw new IllegalArgumentException("잘못된 야구 숫자 입력");
    }

    public void inputRestartSelection() {
        user.selectRestart();

        if (!user.isValidSelection())
            throw new IllegalArgumentException("잘못된 재시작 옵션 입력");
    }
}
