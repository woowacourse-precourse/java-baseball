package baseball.Controller;


import baseball.Service.impl.NumberServiceImpl;
import baseball.Service.interfaces.NumberService;

public class BaseballController {

    private final NumberService numberService = new NumberServiceImpl();

    public void gameStart () throws IllegalArgumentException{
        numberService.createComputerNumber();
        numberService.createUserNumber();
    }

}
