package baseball;

public class Game {
    public static final String PROMPT_MESSAGE = "숫자야구 게임을 시작합니다.";
    private final Computer computer;
    private final Player player;
    private final Compare compare;

    public Game() {
        computer = new Computer();
        player = new Player();
        compare = new Compare();
    }


    public void start() {
        System.out.println(PROMPT_MESSAGE);
        computer.generate();
        do {
            player.setInputNum(PlayerInputView.startInput());
            compare.startCompare(player.getPlayerNum(), computer.getComNum());
        } while (compare.strike != Compare.CLEAR_NUM);

        if (PlayerInputView.restartGame().equals("1")) {
            start();
        }
    }


}
