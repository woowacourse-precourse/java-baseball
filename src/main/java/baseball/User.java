package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class User {
    public static ArrayList<Integer> setUserNumber() {
        ArrayList<Integer> userNumber = new ArrayList<>();

        while(userNumber.size()<3){
            String answer;
            inputMessage();
            answer = Console.readLine();
        }

        return userNumber;
    }
    private static void inputMessage(){
        System.out.println("숫자를 입력해 주세요: ");
    }
}
