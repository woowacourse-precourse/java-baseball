package baseball.vo;

import java.util.List;
import java.util.Objects;

public class UserNumber {
    private final List<Integer> numbers;

    private UserNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumber of(List<Integer> numbers) {
        return new UserNumber(numbers);
    }

    public int size() {
        return numbers.size();
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        return "UserNumber{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof UserNumber)) {
            return false;
        }
        UserNumber anotherUserNumber = (UserNumber) target;
        return numbers.equals(anotherUserNumber.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
