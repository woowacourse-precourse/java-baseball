package baseball.view;

public class InputView {
    private static final String GAME_START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_ENTER_INPUT="숫자를 입력해주세요 : ";
    private static final String REQUEST_SELECT_NEW_GAME_OR_END="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void noticeGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }
    public void requestEnteringNumbers(){
        System.out.print(REQUEST_ENTER_INPUT);
    }
    public void requestMoreGame(){
        System.out.println(REQUEST_SELECT_NEW_GAME_OR_END);
    }

}
