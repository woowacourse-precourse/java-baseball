package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {

    private List<Integer> number;

    public Player() {

    }
    public void input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numberList = Stream.of(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.number = numberList;
        System.out.println("numberList = " + numberList);
    }

}
