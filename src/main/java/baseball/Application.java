package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame(new View(), new BaseballService(new ComputerBaseball()));
        System.out.println("숫자 야구 게임을 시작합니다.");
        baseballGame.start();
    }
}
