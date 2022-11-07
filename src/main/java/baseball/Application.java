package baseball;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        game.start();

        Computer computer = new Computer();
        computer.setAnswer();

        while (true) {

            User user = new User();
            game.printInputNumber();
            user.setNumber();

            game.checkNothing(computer.check, user.check);

            if (!game.nothing) {
                game.countStrike(computer.check, user.check);
                game.countBall();
                game.printResult();
            }

            if (game.state == 1) { // 정답 못맞춘 경우
                game.resetCount();
            }

            if (game.state == 2) { // 정답 맞춰서 게임 끝난 경우
                user.inputGameState();
            }

            if (user.game_state == 1) { // 유저가 새 게임을 시작하는 경우
                computer = new Computer();
                computer.setAnswer();

                game = new Game();
            }

            if (user.game_state == 2) { //유저가 게임을 종료하는 경우
                break;
            }

        }

    }
}
