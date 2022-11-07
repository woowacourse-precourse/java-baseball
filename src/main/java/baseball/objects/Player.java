package baseball.objects;

import baseball.valid.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> numbers;

    public void sayNumbers(String readLine) {
        Validation validation = new Validation(readLine);
        this.numbers = toIntegerList(readLine);
    }

    private  List<Integer> toIntegerList(String readLine) {
        return Arrays.stream(readLine.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public void giveNumbersToReferee(Referee referee) {
        referee.receivePlayerNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
