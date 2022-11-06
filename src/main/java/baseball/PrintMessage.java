package baseball;

public class PrintMessage {
    public static void startMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void inputMessage(){
        System.out.println("숫자를 입력해주세요 : ");
    }
    public static void ballStrikeMessage(int ballCount, int strikeCount){
        if(strikeCount != 3 && strikeCount != 0 && ballCount == 0)
            System.out.println(strikeCount + "스트라이크");
        if(strikeCount != 0 && ballCount != 0)
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        if(strikeCount == 0 && ballCount != 0)
            System.out.println(ballCount + "볼");
        if(strikeCount == 0 && ballCount == 0)
            System.out.println("낫싱");
    }
    public static void answerMessage() {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void gameContinueMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
