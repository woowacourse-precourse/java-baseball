package baseball.model;

public interface Constant {
    String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    String USER_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String GAME_RESTART_OR_TERMINATE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    String STRIKE_MESSAGE = "스트라이크";
    String BALL_MESSAGE = "볼";
    String NOTHING_MESSAGE = "낫싱";
    String BLANK = " ";

    int GAME_RESTART_VALUE = 1;
    int GAME_TERMINATE_VALUE = 2;
    int NUMBER_LENGTH = 3;
    int MIN_NUMBER_VALUE = 1;
    int MAX_NUMBER_VALUE = 9;

    int STRIKE_INDEX = 0;
    int BALL_INDEX = 1;
}
