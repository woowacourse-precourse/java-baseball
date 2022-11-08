package baseball;

public class Constants {

    // play
    public static final int NUMBER_LENGTH = 3;
    public static final int NUMBER_RANGE_START = 1;
    public static final int NUMBER_RANGE_END = 9;
    public static final int OPTION_NUMBER_LENGTH = 1;
    public static final int MISSING_INDEX = -1;
    public static final int RESTART_OPTION = 1;
    public static final int END_OPTION = 2;

    // Guide
    public static final String START_GUIDE = "숫자 아구 게임을 시작합니다.";
    public static final String INPUT_GUIDE = "숫자를 입력해주세요 : ";
    public static final String END_GUIDE =
            String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"
            , NUMBER_LENGTH);
    public static final String RESTART_GUIDE
            = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요."
            , RESTART_OPTION
            , END_OPTION);

    // Result
    public static final String ALL_STRIKE_RESULT
            = String.format("%d스트라이크", NUMBER_LENGTH);

    // validation
    public static final String INVALID_RANGE = String.format("%d ~ %d 사이의 숫자가 아닙니다."
            , NUMBER_RANGE_START
            , NUMBER_RANGE_END);
    public static final String DUPLICATED_NUMBER = "중복된 숫자입니다.";
    public static final String NOT_A_NUMBER = "숫자가 아닙니다.";
    public static final String INVALID_OPTION = String.format("%d 또는 %d를 입력해주세요."
            , RESTART_OPTION
            , END_OPTION);

}
