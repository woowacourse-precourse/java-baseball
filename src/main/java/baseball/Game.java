package baseball;

public class Game {
    private Computer computer;
    private Player player;

    public Game(){
        computer = new Computer();
        player = new Player();
    }
    public void play() {
        int score;

        System.out.println(Message.GAME_START.message());
        do {
            computer.setAnswer();

            do {
                score = computer.computeResult(player.getNumberInput());
            } while (score < Constants.NUMBER_COUNT);

            System.out.println(Message.GAME_END.message());
        } while (player.getRestartOrQuitInput());
    }

    private enum Message {
        GAME_START("숫자 야구 게임을 시작합니다."),
        GAME_END(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Constants.NUMBER_COUNT))
        ;
        private final String message;
        Message(String message) {
            this.message = message;
        }
        private String message(){
            return message;
        }
    }
}
