package baseball.game.support;

public class MessageStore {
    private static final MessageStore instance=new MessageStore();
    private MessageStore(){}
    public static MessageStore getInstance(){
        return instance;
    }
    public void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void inputMessage(){
        System.out.print("숫자를 입력해 주세요 : ");
    }
    public void resultMessage(Integer strikeCount,Integer ballCount){
        strikeMessage(strikeCount,ballCount);
        ballMessage(strikeCount,ballCount);
        strikeAndBallMessage(strikeCount,ballCount);
        notThingMessage(strikeCount,ballCount);
    }
    public void strikeMessage(Integer strikeCount,Integer ballCount){
        if(strikeCount!=0&&ballCount==0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }
    public void ballMessage(Integer strikeCount,Integer ballCount){
        if(strikeCount==0&&ballCount!=0) {
            System.out.println(ballCount + "볼");
        }
    }
    public void strikeAndBallMessage(Integer strikeCount,Integer ballCount){
        if(strikeCount!=0&&ballCount!=0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }
    public void notThingMessage(Integer strikeCount,Integer ballCount){
        if(strikeCount==0&&ballCount==0) {
            System.out.println("낫싱");
        }
    }
    public void gameEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void continueMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
