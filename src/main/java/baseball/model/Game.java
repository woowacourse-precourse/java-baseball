package baseball.model;

import baseball.controller.HintMaker;
import baseball.view.Printer;
import baseball.view.Session;

public class Game {
    private static final String RESTART = "1";
    private final User user;
    private final Computer computer;
    private final HintMaker hintmaker;

    public Game() {
        user = new User();
        computer = new Computer();
        hintmaker = new HintMaker();
    }

    public void start() {
        Printer.printStart();
        computer.initAnswer();
        computer.makeAnswer();
        do {
            Printer.printInputGuide();
            user.initData();
            user.editNumberString(Session.getThreeNumbers());
        } while (!hintmaker.isAnswer(user.getUserData(), computer.getAnswer()));

        Printer.printEnd();
        Printer.askRestart();
        String choice = Session.getRestartCondition();
        if (RESTART.equals(choice)) {
            start();
        }
    }
}
