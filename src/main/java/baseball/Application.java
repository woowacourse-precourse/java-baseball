package baseball;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        service.initGame();
        view.printInitMsg();
        while(true) {
            view.printInputMsg();
            String userInput = view.getUserInput();
            Score score = service.calculateScore(userInput);
            view.printResultMsg(score);

            if (score.getStrike() != 3) continue;

            view.printSuccessMsg();
            view.printRestartMsg();
            userInput = view.getUserResponse();

            if (userInput.compareTo("1") == 0) {
                service.initGame();
                view.printInitMsg();
            } else {
                return;
            }
        }
    }
}
