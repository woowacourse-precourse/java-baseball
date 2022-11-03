package baseball;

public class Message {
    private static final String startMessage = "숫자 야구게임을 시작합니다.";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String inputMessage = "숫자를 입력해주세요: ";

    public Message() {
    }

    public void printStartMessage(){
        System.out.println(startMessage);
    }

    public void printInputMessage(){
        System.out.print(inputMessage);
    }

    public void printRestartMessage(){
        System.out.println(restartMessage);
    }
}
