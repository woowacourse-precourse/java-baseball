package baseball.service;

import baseball.User;

public interface BaseballGameService {

    void run(User user);

    String getResultMessage(User user);
}
