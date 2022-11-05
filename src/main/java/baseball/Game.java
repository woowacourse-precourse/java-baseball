package baseball;

import static baseball.Constraint.OPENING_MENT;

public class Game {

    private final ComputerNums computerNums;
    private final PlayerNums playerNums;

    public Game() {
        this.computerNums = new ComputerNums();
        this.playerNums = new PlayerNums();
    }


    public String opening() {
        return OPENING_MENT;
    }

    public void doGame() {
        //TODO: 게임을 수행한다. (컴퓨터 랜덤 생성, 사용자 입력 받기, 비교하기, 정답인 경우 return )
        this.computerNums.setNums();
        do {
            try {
                playerNums.setNums();
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                break;
            }
        } while (true);

    }

    public ComputerNums getComputerNums() {
        return computerNums;
    }

    public PlayerNums getPlayerNums() {
        return playerNums;
    }
}
