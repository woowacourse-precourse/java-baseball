package baseball.service;

import baseball.model.BaseBall;

public class BaseBallService {

    private static BaseBall baseBall;

    public void init() {
        baseBall = new BaseBall();
    }
}
