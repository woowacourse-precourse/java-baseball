package baseball.repository;

import baseball.domain.Computer;

public class ComputerRepository {

    private Computer computer;

    public void setComputer(int firstNumber, int secondNumber, int thirdNumber){
        this.computer = new Computer(firstNumber,secondNumber,thirdNumber);
    }

    public Computer getComputer() {
        return this.computer;
    }

}
