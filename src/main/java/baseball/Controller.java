package baseball;

import net.bytebuddy.matcher.StringMatcher;

public class Controller {
    private Model computer;
    private Model user;

    public Controller(Model computer, Model user) {
        this.computer = computer;
        this.user = user;
    }

    public void setNumber(Model model, String number){
        model.setNumber(number);
    }

    public String getNumber(Model model){
        return model.getNumber();
    }

    public String[] splitNumber(String number){
        String[] numbers = number.split("");
        return numbers;
    }

    
}
