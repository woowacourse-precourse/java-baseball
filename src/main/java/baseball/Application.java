package baseball;

public class Application {
    public static void main(String[] args) {
        int gameStart = INITE_GAME_START_VALUE;

        /* 프로그램 메인 구조, 게임 중단 플래그가 세워질 때 까지 반복, 예외 발생 시 프로그램 중단 */
        while(gameStart == FLAG_RETRY_INT) {
            try {
                gameStart = playBall();
            } catch(IllegalArgumentException exception) {
                exception.printStackTrace();
                return;
            }
        }
    }

    private static int playBall() {
        /* 컴퓨터 숫자 정하기 파트 */
        final List<Integer> COMPUTERS_NUMBERS;

        /* 게임 시퀀스 루프 */
        int strike = INITE_STRIKE_COUNT;
        while(strike < MAX_STRIKE_COUNT) {

        }

        /* 게임 재시작 여부 확인 파트 */

        return /* gameStart 변수에 입력할 값 1 or 2 */;
    }
}
