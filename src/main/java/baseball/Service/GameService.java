package baseball.Service;

import baseball.Domain.*;

import java.util.List;

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

    public void getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        player.insertPlayerNumbers();
    }

    public void countResult() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int comDigit = computer.getGameNumbers().get(i);
            int playerDigit = player.getPlayerGameNumbers().get(i);
            if (comDigit == playerDigit) {
                strike++;
            }
            if (computer.getGameNumbers().contains(player.getPlayerGameNumbers().get(i))) {
                ball++;
            }
        }
        ball -= strike;
        hint.setGameResult(List.of(strike, ball));
    }

    public boolean checkIsAnswer() {
        return hint.getIsAnswer();
    }

    public void showResult() {
        hint.printResult();
    }

    public void showEndMessage() {
        hint.printEndMessage();
    }

    public GameStatus askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerAnswer = player.getAnswerAboutRestart();

        if (playerAnswer == GameStatus.PlAY.label()) {
            computer.makeRandomNumbers();
            return GameStatus.PlAY;
        }
        if (playerAnswer == GameStatus.FINISH.label()) {
            return GameStatus.FINISH;
        }
        throw new IllegalArgumentException("게임 재시작 여부에 대한 입력값이 잘못되었습니다.");
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
