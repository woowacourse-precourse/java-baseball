package baseball;

import java.util.List;

public class BaseballGame {
    public void start() {
        System.out.println(GameMessage.start);
    }

    public void isNothing(List<Integer> computer, List<Integer> user) {
        if (!computer.contains(user)) {
            System.out.println(GameMessage.nothing);
        }
    }
}
