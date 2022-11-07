package baseball.domain;

public class Computer {

    private BaseBallNumber computer_number;

    public void generateComputerNumber() {
        computer_number = BaseBallNumber.generateComputerNumber();
    }


    public BaseBallNumber getComputerNumber() {

        return computer_number;
    }
}
