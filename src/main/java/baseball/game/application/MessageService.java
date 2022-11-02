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
}
