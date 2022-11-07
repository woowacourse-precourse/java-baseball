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
