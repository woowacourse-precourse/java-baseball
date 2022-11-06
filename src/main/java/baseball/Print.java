package baseball;

public class Print {
    private static final String GET_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String NEW_CHECK_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String EXIT_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String SIZE_EXCEPTION_MSG = "3개 숫자를 입력하세요.";
    public static final String DUPLICATE_EXCEPTION_MSG = "각각 3개의 다른 숫자를 입력하세요.";
    public static final String NEWGAME_EXCEPTION_MSG = "1이나 2를 입력하세요.";
    public static final String RANGE_EXCEPTION_MSG = "1 ~ 9사이의 값을 입력하세요.";
    public static final String NUMBERONLY_EXCEPTION_MSG = "숫자만 입력해주세요.";
    public static void resultPrint(int strikeCount,int ballCount){

        if(strikeCount==0 && ballCount==0){
            System.out.println(NOTHING);
        }else if(ballCount > 0 && strikeCount == 0){
            System.out.println(ballCount+BALL);
        }else if(strikeCount > 0 && ballCount == 0){
            System.out.println(strikeCount+STRIKE);
        }else if(strikeCount > 0 && ballCount > 0){
            System.out.println(ballCount+BALL+" "+strikeCount+STRIKE);
        }

    }
    public static void printGetNumberMessage(){
        System.out.print(GET_NUMBER_MSG);
    }
}
