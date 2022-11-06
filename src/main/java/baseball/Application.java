package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            Game game = new Game();
            System.out.println("컴퓨터수: " + game.computer);
            System.out.println("숫자 야구 게임을 시작합니다.");

            boolean b;
            do {
                System.out.print("숫자를 입력해주세요 : ");
                String userAnswer = game.inputUserAnswer();
                game.checkExceptions(userAnswer);
                game.stringToListInteger(userAnswer);
                b = game.checkUserAnswerWhichIsCorrect(userAnswer);
            } while (!b);

            if (game.replayGame().equals("2")) {
                break;
            }
        }
    }
}
