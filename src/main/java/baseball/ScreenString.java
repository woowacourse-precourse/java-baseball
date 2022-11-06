package baseball;

public enum ScreenString {

    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요"),
    OUTPUT_BALL("볼"),
    OUTPUT_STRIKE("스트라이크"),
    NOTHING("낫싱"),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    ScreenString(String m){
        this.message = m;
    }

    public String getCommonMessage(){
        return message;
    }

    public static String ballAndStrikeMessage(int ballCount, int strikeCount){
        if(ballCount == 0 && strikeCount == 0){
            return NOTHING.message;
        }else if(strikeCount == 0) {
            return Integer.toString(ballCount) + OUTPUT_BALL.message;
        }else if(ballCount == 0){
            return Integer.toString(strikeCount) + OUTPUT_STRIKE.message;
        }else{//볼 스트라이크 둘 다 있는 경우 재귀 호출로 해결
            return ballAndStrikeMessage(ballCount,0)+" "+ballAndStrikeMessage(0,strikeCount);
        }
    }
}
