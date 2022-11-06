package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public void validateNumbers() {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("입력된 수가 지정 갯수 초과입니다.");
        }
        if (numbers.stream().distinct().toArray().length != 3) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    public void validateNumber(int number){
        if(number<1||number>9){
            throw new IllegalArgumentException("숫자가 1~9 사이의 수가 아닙니다.");
        }
    }

    public int check(int number, int index){
        if(numbers.get(index)==number){
            return 2;
        }
        if(numbers.contains(number)){
            return 1;
        }
        return 0;
    }

    public void add(int number) {
        validateNumber(number);
        numbers.add(number);
    }

    public boolean isContaining(int number){
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    public int get(int index){
        return numbers.get(index);
    }
}
