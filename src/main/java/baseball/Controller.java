package baseball;

public class Controller {
    private Model computer;
    private Model user;

    public Controller(Model computer, Model user) {
        this.computer = computer;
        this.user = user;
    }

    public void setComputerNumber(String number){
        computer.setNumber(number);
    }

    public void setUserNumber(String number){
        user.setNumber(number);
    }

    public String[] splitNumber(String number){
        String[] numbers = number.split("");
        return numbers;
    }
}
