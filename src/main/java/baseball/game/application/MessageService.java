package baseball.game.application;

public class MessageService {
    private static final MessageService instance=new MessageService();
    private MessageService(){}
    public static MessageService getInstance(){
        return instance;
    }
    public void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void inputMessage(){
        System.out.print("숫자를 입력해 주세요 : ");
    }
    public void strikeMessage(Integer strikeCount){
        System.out.println(strikeCount+"스트라이크");
    }
    public void ballMessage(Integer ballCount){
        System.out.println(ballCount+"볼");
    }
    public void strikeAndBallMessage(Integer strikeCount,Integer ballCount){
        System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
    }
    public void notThingMessage(){
        System.out.println("낫싱");
    }
    public void gameEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void continueMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
