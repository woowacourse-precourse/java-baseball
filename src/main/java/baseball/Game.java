package baseball;

public class Game {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE =
            String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Constants.NUMBER_COUNT);

    public void play() {
        Computer computer = new Computer();
        Player player = new Player();

        int score;

        System.out.println(GAME_START_MESSAGE);
        do {
            computer.setAnswer();

            do {
                score = computer.computeResult(player.getNumberInput());
            } while (score < Constants.NUMBER_COUNT);

            System.out.println(GAME_END_MESSAGE);
        } while (player.getRestartOrQuitInput());
    }
}
