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
