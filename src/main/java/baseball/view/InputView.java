package baseball.view;

public class InputView {
    private static final String GAME_START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_ENTER_INPUT="숫자를 입력해주세요 : ";

    public void noticeGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }
    public void requestEnteringNumbers(){
        System.out.print(REQUEST_ENTER_INPUT);
    }

}
