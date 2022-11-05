package baseball;

public class Application {
    public static void main(String[] args) {
        boolean restart = true;
        while (restart) {
            User user = new User();
            Game game = Game.start(user);
            game.user.guess();
            int strike = game.computer.strike(game.user.guess);
            int ball = game.computer.ball(game.user.guess);
            game.hint(strike, ball);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = game.restart();
            }
        }
    }
}
