package baseball;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        game.start();

        disableWarning();

        Computer computer = new Computer();
        computer.madeAnswer();

        while (true) {

            User user = new User();
            game.printInputNumber();
            user.madeAnswer();

            game.countSameNumber(computer.numberList, user.numberList);
            game.checkNothing();

            if (!game.nothing) {
                game.countStrike(computer.numberList, user.numberList);
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
                computer.madeAnswer();

                game = new Game();
            }

            if (user.game_state == 2) { //유저가 게임을 종료하는 경우
                break;
            }

        }

    }

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

}
