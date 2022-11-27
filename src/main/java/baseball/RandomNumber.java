package baseball;

public class RandomNumber {
    private Integer randomNumber;

    private RandomNumber(Integer randomNumber) {
        Exception.randomNumberRangeException(randomNumber);
        this.randomNumber = randomNumber;
    }

    public static RandomNumber valueOf(Integer randomNumber) {
        Exception.randomNumberRangeException(randomNumber);

        return new RandomNumber(randomNumber);
    }

    @Override
    public String toString() {
        return randomNumber.toString();
    }
}
