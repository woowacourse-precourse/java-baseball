package baseball;

public class Controller {
    private Model computer;
    private Model user;

    public Controller(Model computer, Model user) {
        this.computer = computer;
        this.user = user;
    }

    public void setComputerNumber(int number){
        computer.setNumber(number);
    }

    public void setUserNumber(int number){
        user.setNumber(number);
    }
}
