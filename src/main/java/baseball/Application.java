package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    static List<Integer> randNumber() {
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
        return computer;
    }
    static List<Integer> userHasNumber(int userNumber) {

        int[] Numberdata = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> userNumbers = Arrays.stream(Numberdata) .boxed() .collect(Collectors.toList());
        if(!InputNumberValidator.inputNumberExceptionCheck(userNumbers))
        {
            throw new IllegalArgumentException();
        }
        return userNumbers;
    }
    static int inputUserNumber(){
        String userNumber_str;
        int userNumber;
        System.out.print("숫자를 입력해주세요 : ");
        userNumber_str = Console.readLine();
        if (userNumber_str.isBlank()) throw new IllegalArgumentException();
        try{
            userNumber = Integer.parseInt(userNumber_str);
            System.out.println(userNumber);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return userNumber;


    }




    public static void main(String[] args) {
        // TODO: 프로그램 구현
            boolean Game = true;
            int ret = 0;
            while(Game) {
                List<Integer> computerNumber = randNumber();
                startGame(computerNumber);
                Game = reTry();
            }
    }
}
