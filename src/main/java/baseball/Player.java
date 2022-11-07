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
        if (readLine.length() != 3) {
            throw new IllegalArgumentException("Numbers is size Exception!!");
        }
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receivePlayerNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
