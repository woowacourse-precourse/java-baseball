package baseball;

public class NumberBaseball {

    BaseballController controller = new BaseballController();

    public void startGame() {

        while (true) {
            controller.startBaseBall();
            if(controller.checkEndGame()) {
                break;
            }
        }
    }
}
