package baseball.Service;

import baseball.Domain.*;

public class GameService {

    private Computer computer;
    private Player player;
    private Hint hint;

    public void gameStart(Computer com, Player player, Hint result) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        setCom(com);
        setPlayer(player);
        setHint(result);
    }

    public void makeComputerNum() {
        computer.makeRandomNumbers();
    }


    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }
    public void setCom(Computer com) {
        this.computer = com;
    }


    public Hint getHint() {
        return hint;
    }
    public void setHint(Hint hint) {
        this.hint = hint;
    }


}
