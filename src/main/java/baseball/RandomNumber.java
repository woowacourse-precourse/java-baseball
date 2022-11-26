package baseball;

public class RandomNumber {
    private Integer randomNumber;

    public RandomNumber(Integer randomNumber) {
        Exception.randomNumberRangeException(randomNumber);
        this.randomNumber = randomNumber;
    }

    @Override
    public String toString() {
        return randomNumber.toString();
    }
}
