package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public static String getNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        if (userNumber.length() != 3){
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

}
