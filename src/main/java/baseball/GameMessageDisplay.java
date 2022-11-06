package baseball;

public class GameMessageDisplay {
    protected String message;
    public void setMessage(String newMessage) {
        this.message = newMessage;
    }
    public void printMessage() {
        System.out.println(this.message);
    }
    public void printGameStartMessage() {
        setMessage("숫자 야구 게임을 시작합니다.");
        printMessage();
    }
}
