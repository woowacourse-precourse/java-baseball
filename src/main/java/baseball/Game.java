package baseball;

public class Game {
    private static final String START_MSG  = "숫자 야구 게임을 시작합니다.";
    private static final Computer computer = new Computer();

    public void start() {
        System.out.println(START_MSG);
        System.out.println(computer);
    }


}
