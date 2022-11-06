package baseball;

public class Game {
    private static final int CONTINUE = 1;
    private static final int END = 2;

    public Game() {
    }

    private static void playGame(Computer computer, User user) {
        int game = CONTINUE;
        while (isContinue(game)) {
            System.out.print("숫자를 입력해주세요 : ");
            Ball ball = computer.compareDigits(user.input());
            System.out.println(ball.toString());
            game = isEnd(ball);
        }
    }

    private static boolean isContinue(int game) {
        return game == CONTINUE;
    }

    private static int isEnd(Ball ball) {
        if (ball.isEnd())
            return END;
        return CONTINUE;
    }
}
