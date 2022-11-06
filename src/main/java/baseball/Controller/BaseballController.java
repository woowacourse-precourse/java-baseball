package baseball.Controller;


import baseball.Service.impl.NumberServiceImpl;
import baseball.Service.interfaces.NumberService;
import baseball.View.PrintInformationView;

import static baseball.View.PrintInformationView.printGameStartMessage;
import static baseball.View.PrintInformationView.printRequestNumber;

public class BaseballController {

    private final NumberService numberService = new NumberServiceImpl();
    private final PrintInformationView printInformationView = new PrintInformationView();

    public void gameStart () throws IllegalArgumentException{
        printGameStartMessage();
        numberService.createComputerNumber();

        printRequestNumber();
        numberService.createUserNumber();



    }

}
