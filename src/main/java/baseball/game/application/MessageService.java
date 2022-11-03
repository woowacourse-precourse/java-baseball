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
        System.out.println(strikeCount+" 스트라이크");
    }
    public void ballMessage(Integer ballCount){
        System.out.println(ballCount+" 볼");
    }
    public void strikeAndBallMessage(Integer strikeCount,Integer ballCount){
        System.out.println(ballCount+" 볼 "+strikeCount+" 스트라이크");
    }


}
