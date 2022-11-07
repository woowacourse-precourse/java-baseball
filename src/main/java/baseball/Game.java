package baseball;

import java.util.List;

public class Game {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";

    private boolean gameContinue = true;

    private List<Integer> computer;
    private List<Integer> player;

    public void startGame() {
        System.out.println(START_SENTENCE);

        setComputer();

        while (gameContinue) {
            setPlayer();
        }
    }

    private void setComputer() {
        Number number = new Number();
        this.computer = number.getComputerNumber();
    }

    private void setPlayer() {
        Number number = new Number();
        this.player = number.getPlayerNumber();
    }
}
