package baseball;

public class PrintMessage {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String CONTINUE_GAME_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void startMessage(){
        System.out.println(START_MESSAGE);
    }
    public static void requestInputMessage(){
        System.out.print(INPUT_MESSAGE);
    }
    public static void ballStrikeMessage(int ballCount, int strikeCount){
        if(strikeCount != 3 && strikeCount != 0 && ballCount == 0)
            System.out.println(strikeCount + STRIKE);
        if(strikeCount != 0 && ballCount != 0)
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
        if(strikeCount == 0 && ballCount != 0)
            System.out.println(ballCount + BALL);
        if(strikeCount == 0 && ballCount == 0)
            System.out.println(NOTHING);
    }
    public static void resultMessage() {
        System.out.println(END_MESSAGE);
    }
    public static void askContinueMessage(){
        System.out.println(CONTINUE_GAME_ASK);
    }
}
