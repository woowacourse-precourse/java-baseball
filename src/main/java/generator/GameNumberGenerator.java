package generator;

import java.util.*;

public class GameNumberGenerator {
    private List<Integer> numbers; // 수집된 숫자들을 저장

    public GameNumberGenerator() {
        this.numbers = new ArrayList<>(3);
    }

    public GameNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /*
    * 무작위로 발생한 서로 다른 3개의 수로 구성된 수열을 List<Integer>로 구성함
    */
    public String getNumber() {
        while(numbers.size() < 3) {
            int number = RandomNumberGenerator.getNumber();
            if(!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return this.getNumberString();
    }

    /*
    * 구성된 List<Integer>를 문자열의 형태로 반환함
    */
    private String getNumberString() {
        StringBuilder sb = new StringBuilder();
        for(int number : numbers) {
            sb.append(number);
        }
        numbers.clear(); // 재사용을 위해 비움
        return sb.toString();
    }
}
