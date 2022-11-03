package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            BullsAndCows game = new BullsAndCows();
            do {
                game.playGame();
            } while ((doRepeat()) == 1);

        } catch (IllegalArgumentException exception) {
            System.out.println("잘못된 값을 입력하셨습니다. 프로그램을 종료합니다.");
       }
    }

    private static int doRepeat() {
        int input = 0;
        // "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
        return input;
    }

}
