package baseball;

public class Application {
    public static void main(String[] args) {
        String input;
        int flag = 1;

        while (flag == 1) {
            doGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            // flag = continueOrEnd();
        }
    }

    public static void doGame() {
        String input = "";
        Game game = new Game();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!game.isEnd(input)) {
            input = Console.readLine();
            if (InputCheck.isInputError(input)) {
                throw new IllegalArgumentException("입력오류");
            }
            game.play(input);
        }
    }
}
