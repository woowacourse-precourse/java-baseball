package baseball;

public class Application {
    public static void main(String[] args) {
        Stadium stadium = new Stadium();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            stadium.playGame();
            if (stadium.computer.restartNumber.equals("2")) {
                break;
            }
        }
    }
}