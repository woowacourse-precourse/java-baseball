package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> numbers;

    public void sayNumbers(String readLine) {
        validNumbers(readLine);
        this.numbers = toIntegerList(readLine);
    }

    private  List<Integer> toIntegerList(String readLine) {
        return Arrays.stream(readLine.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private void validNumbers(String readLine) {
        if (!isDigit(readLine) || readLine.length() != 3) {
            throw new IllegalArgumentException("Number is Not Valid Exception!!");
        }
    }

    private static boolean isDigit(String readLine) {
        return readLine.chars().allMatch(Character::isDigit);
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receivePlayerNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
