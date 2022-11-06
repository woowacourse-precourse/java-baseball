package baseball;

public enum ScreenString {

    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요"),
    OUTPUT_BALL("볼"),
    OUTPUT_STRIKE("스트라이크"),
    NOTHING("낫싱"),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    ScreenString(String m){
        this.message = m;
    }

    public String getCommonMessage(){
        /**
         * 일반 메시지
         */
    }

    public String ballAndStrokeMessage(int ballCount, int strikeCount){
        /**
         * 게임 메시지
         */
    }
}
