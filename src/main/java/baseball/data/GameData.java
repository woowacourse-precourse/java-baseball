package baseball.data;

/**
 * 게임 내 상수값들을 모아둔 클래스
 */
public class GameData {
    //게임 시작 설정
    public static final int GAME_SIZE = 3;
    public static final int RESTART_SIZE = 1;
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    // 자릿수 분리하기 위한 상수들
    public static final int DIVIDE_INITIATE = 100; // 나눌 초기값
    public static final int DIVIDE_TARGET = 10; // 단계별로 줄어드는 자릿수

    // 재시작 확인을 위한 문자열
    public static final String RESTART = "1";
    public static final String GAME_OVER = "2";

    private GameData () { }
}
