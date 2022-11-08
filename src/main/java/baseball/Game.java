package baseball;

public class Game {
    private static final int MAX_STRIKE = 3;
    private static final Computer computer = new Computer();
    private static final Player player = new Player();
    private boolean isGameEnd = false;
    private int strike = 0;
    private int ball = 0;
    public void start() {
        while(!isGameEnd) {
            // 게임 초기화
            while(strike != MAX_STRIKE) {
                // 플레이어가 수 입력
                // 컴퓨터와 플레이어 수 비교
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            // 게임 다시 시작 or 완전 종료 선택
        }
    }
}
