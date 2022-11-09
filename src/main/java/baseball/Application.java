package baseball;

/*
        // 객체 지향 프로그래밍
        // 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
        // 2. 필요한 기능을 (역할에 맞는) 각 인스턴스가 수행하게 한다. (의인화)
        // 3. 각 결과를 종합한다.
 */

import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //NumberGenerator generator = new NumberGenerator();
        //List<Integer> numbers = generator.createRandomNumber();
        // System.out.println(numbers);

        Judgement judgement = new Judgement();
        final int count = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(6, 8, 9));
        System.out.print(count);
    }
}