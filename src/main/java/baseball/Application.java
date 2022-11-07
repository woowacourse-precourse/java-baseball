package baseball;

import baseball.controller.Controller;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        View view = new View();
        Controller controller = new Controller(computer, user, view);
        String userInput = Console.readLine();

    }
}
