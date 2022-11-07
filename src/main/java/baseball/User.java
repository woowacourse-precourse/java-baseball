package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    BaseballGame baseballGame;

    public User() {};

    public void Game() {
        baseballGame = new BaseballGame();

        System.out.print("숫자를 입력해주세요 : ");
        int userNumber = input();
    }

    public int input() {
        return Integer.parseInt(readLine());
    }
}
