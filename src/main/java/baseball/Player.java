package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    private final int NUMBER_LENGTH = 3;
    private List<Integer> number;

    public Player() {

    }
    public void input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try{
            List<Integer> numberList = Stream.of(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            checkNumber(numberList);

            this.number = numberList;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void checkNumber(List<Integer> number){
        if(checkSize(number) && checkDuplicate(number)){
            return;
        }
        throw new IllegalArgumentException();
    }
    private boolean checkSize(List<Integer> number){
        return number.size() == NUMBER_LENGTH;
    }

    private boolean checkDuplicate(List<Integer> number){
        long count = number.stream()
                .distinct()
                .count();
        return count == NUMBER_LENGTH;
    }


}
