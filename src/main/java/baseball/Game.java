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
        //1. 컴퓨터 랜덤 넘버 생성
        this.computerNums.setNums();
        //2. 사용자 입력 받기
        do {
            playerNums.setNums();
        } while (true);

    }

    public ComputerNums getComputerNums() {
        return computerNums;
    }
}
