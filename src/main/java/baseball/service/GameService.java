package baseball.service;

import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private User user;

    public void start() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputText = Console.readLine();
        this.user = new User(inputText);
    }
}
