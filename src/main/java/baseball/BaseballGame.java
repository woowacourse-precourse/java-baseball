package baseball;

import java.util.List;

public class BaseballGame {
    public void start() {
        System.out.println(GameMessage.start);
    }

    public void isNothing() {
        List<Integer> userNumber = User.userNumber();
        List<Integer> computerNumber = Computer.computerNumber();

        if(!computerNumber.contains(userNumber)) {
            System.out.println(GameMessage.nothing);
        }
    }
}
