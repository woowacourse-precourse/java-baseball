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

    private void finish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        askGameContinue();
    }

    private void askGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        status = Integer.parseInt(readLine(GameCode.CONTINUE.getValue()));

        if (status == GameCode.PLAY.getValue()) {
            updateGame();
        }
    }

    private void updateGame() {
        this.judge.setDefend(player.defend());
    }


    public void play() {

        attack();

        String gameResult = judge.judge();
        System.out.println(gameResult);

        if (gameResult.equals("3스트라이크")) {
            finish();
        }
    }

    public int getStatus() {
        return status;
    }


}
