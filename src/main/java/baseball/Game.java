package baseball;

public class Game {
    public static Number computerNumber;

    public Game() {
        init();
    }

    public void init() {
        computerNumber = Utils.pickComputerNumber();
        System.out.println(computerNumber);
    }

    public void start() {
        while (true) {
            Stage stage = new Stage(computerNumber);
            stage.start();
            if (stage.isComplete()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
