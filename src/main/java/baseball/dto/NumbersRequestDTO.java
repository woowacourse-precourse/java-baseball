package baseball.dto;

public class NumbersRequestDTO {

    private int inputNumber;

    public NumbersRequestDTO(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getInputNumber() {
        return this.inputNumber;
    }
}
