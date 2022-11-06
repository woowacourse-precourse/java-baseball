package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player computer = createPlayer(NumberUtil.random());
        Player user = createPlayer(NumberUtil.input());
        if (!user.isPossiblePlay()) {
            throw new IllegalArgumentException();
        }
    }

    public static Player createPlayer(List<Integer> numbers) {
        return new Player(numbers);
    }
}
