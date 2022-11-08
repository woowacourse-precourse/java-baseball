package baseball;

import baseball.logic.Randomnumber;
import baseball.logic.Inputnumber;
import baseball.logic.RestartValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    static final int inputsize = 3;
    private int strike;
    private int ball;
    private List<Integer> playerInputList;
    private List<Integer> computerInputList;

    private final Randomnumber computerNum;
    private final Inputnumber playerNum;


    public BaseballGame() {
        strike = 0;
        ball = 0;
        playerInputList = new ArrayList<>();
        computerInputList = new ArrayList<>();
        playerNum = new Inputnumber();
        computerNum = new Randomnumber();
    }

    public void play() {
        computerNum.generateNumber();
        computerInputList = computerNum.getNum();
        do {
            playerInputList = playerNum.getNum();
            strike = 0;
            ball = 0;
            cntScore();
            messageHint();
        } while (!(strike == 3));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void cntScore() {
        cntStrike(playerInputList, computerInputList);
        cntBall(playerInputList, computerInputList);
    }

    public void messageHint() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public int cntStrike(List<Integer> player, List<Integer> computer) {
        for (int i = 0; i < inputsize; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int cntBall(List<Integer> player, List<Integer> computer) {
        for (int i = 0; i < inputsize; i++) {
            if (computer.contains(player.get(i)) && computer.get(i) != player.get(i)) {
                ball++;
            }
        }
        return ball;
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartInput = Console.readLine();

        if (!RestartValidation.checkRestart(restartInput)) {
            throw new IllegalArgumentException();
        }
        return restartInput.equals("1");
    }
}
