package baseball.contants;

public class Contants {
    public static final int LIST_SIZE = 3;
    public static final String NEW_GAME = "1";
    public static final String END_GAME = "2";
    public static final String NOTICE_START = "숫자 야구 게임을 시작합니다.";
    public static final String NOTICE_INPUT = "숫자를 입력해주세요 : ";
    public static final String NOTICE_REQUEST_NEW_GAME = "게임을 새로 시작하려면 "+NEW_GAME+", 종료하려면 "+END_GAME+"를 입력하세요.";
    public static final String NOTICE_CLEAR = LIST_SIZE+"개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String EXCEPTION_CHOICE = NEW_GAME+" 혹은 "+END_GAME+"만 입력하세요.";
    public static final String EXCEPTION_DUPLICATED = "중복된 숫자가 존재합니다.";
    public static final String EXCEPTION_OVER_RANGE = "1 ~ 9 사이 숫자를 입력하세요.";
}
