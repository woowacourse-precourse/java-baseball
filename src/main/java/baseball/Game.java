package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final int CONTINUE = 1;
    private static final int END = 2;

    private int system = CONTINUE;

    public Game() {
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isContinue(system)) {
            Computer computer = new Computer();
            User user = new User();

            playGame(computer, user);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String select = inputSelect();
            validateSelect(select);
            system = Integer.parseInt(select);
        }
    }

    private static void validateSelect(String select) {
        if (select.length() != 1 || !Character.isDigit(getCharacter(select)) || !isRightSelect(select))
            throw new IllegalArgumentException("1이나 2만 입력 가능합니다.");
    }

    private static boolean isRightSelect(String select) {
        int digit = Integer.parseInt(select);
        return digit == CONTINUE || digit == END;
    }

    private static char getCharacter(String select) {
        return select.charAt(0);
    }

    private String inputSelect() {
        return Console.readLine();
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
