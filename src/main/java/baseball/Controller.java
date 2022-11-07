package baseball;

public class Controller {

    Service service = new Service();
    public void start() {
        service.startGame();
    }
}
