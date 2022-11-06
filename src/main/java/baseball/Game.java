package baseball;

public class Game {
    public static final String PROMPT_MESSAGE = "숫자야구 게임을 시작합니다.";
    Computer computer = new Computer();
    Player player = new Player();

    public void start() {
        System.out.println(PROMPT_MESSAGE);
        computer.generate();
        player.setInputNum(PlayerInputView.startInput());
    }
}
