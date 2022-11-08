package baseball.model;

import static baseball.util.InputUtility.readLine;

import baseball.util.GameCode;

public class Game {

    private Player player;
    private Judge judge;

    private int status;


    private Game() {
        this.player = new Player();
        this.judge = new Judge(player.defend());
        this.status = GameCode.PLAY.getValue();
    }

    public static Game start() {
        return new Game();
    }

    private void attack() {
        judge.setAttack(player.attack(askAttackNumber()));
    }
    private String askAttackNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine(GameCode.ATTACK.getValue());
    }


}
