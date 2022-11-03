package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BullsAndCows game = new BullsAndCows();
        do {
            game.playGame();
        } while ((doRepeat()) == 1);
    }

    private static int doRepeat() {
        int input = 0;
        // "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
        return input;
    }

}
