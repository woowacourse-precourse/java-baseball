package baseball.Controller;


import baseball.Model.NumberItem;
import baseball.Service.impl.CompareServiceImpl;
import baseball.Service.impl.NumberServiceImpl;
import baseball.Service.interfaces.CompareService;
import baseball.Service.interfaces.NumberService;
import baseball.View.PrintInformationView;
import camp.nextstep.edu.missionutils.Console;

import static baseball.View.PrintInformationView.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballController {

    private final NumberService numberService = new NumberServiceImpl();
    private final CompareService compareService = new CompareServiceImpl();
    private final PrintInformationView printInformationView = new PrintInformationView();

    public void gameStart () throws IllegalArgumentException{
        printGameStartMessage();
        NumberItem computerNumberItem = numberService.createComputerNumber();
        System.out.println("computerNumberItem.getNumber() = " + computerNumberItem.getNumber());
        int compareResult = 0;
        while(compareResult != 1) {
            printRequestNumber();
            NumberItem userNumberItem = numberService.createUserNumber();
            compareResult = compareService.compare(computerNumberItem, userNumberItem);
            if(compareResult == 1){
                printCorrectMessage();
                printRestartMessage();
                String restart = Console.readLine();
                if(restart.equals("1")) {
                    gameStart();
                }
            }
        }






    }

}
