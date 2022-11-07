package baseball;

import baseball.constants.Constants;

public class Application {
    public static void main(String[] args) {
    	System.out.println(Constants.startMessage);
    	Controller controller = new Controller();
    	controller.run();
    }
}
