package baseball;

public class NumberBaseball {

    BaseballController controller = new BaseballController();

    public void startGame() {

        while (true) {
            controller.startBaseBall();
            if(controller.checkEndGame()) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
