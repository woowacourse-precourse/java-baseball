package baseball.entity;

import baseball.constant.Message;

public class Game {

    // 스트라이크 개수, 볼 개수를 관리하는 객체 Score
    // 게임 진행 상태
    private static final int RUNNING = 0;
    private static final int START = 1;
    private static final int STOP = 2;

    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Score score = new Score();

    private int GAME_STATE = START;

    // init(): Computer측 랜덤 숫자 생성
    public void init(){
        computer.createRandomNumber();
    }

    // start(): 상태가 진행중이면, run()을 반복해서 호출

    // run():
        // 문구 출력
        // input()
        // updateScore()
        // 게임 진행 상태 갱신
        // 결과 문구 출력


    // input(): 유저에게 입력 받기
    private void input() {
        player.enterInput();
    }

    // updateScore(): 볼 개수와 스트라이크 개수
    private void updateScore(){
        computer.countBallAndStrike(player.getPlayerNumbers(), score);
    }
}