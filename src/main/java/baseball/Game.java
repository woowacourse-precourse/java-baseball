package baseball;

public class Game {
    public static Number computerNumber;

    public void init() {
        computerNumber = Utils.pickComputerNumber();
        System.out.println(computerNumber);
    }

    public Game() {
        init();
    }

    public void start() {
        boolean status = true;
        while (status) {
            Stage stage = new Stage(computerNumber);
            stage.progress();
            if (stage.isComplete()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                status = false;
            }
        }
    }
}
