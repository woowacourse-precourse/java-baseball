package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class UserInput {

    public static List<Integer> userInput() throws IllegalArgumentException{

        List<Integer> user = new ArrayList<>();
        String userNumber = Console.readLine();
        String[] userNumberSplit = userNumber.split("");

        if(userNumber.length() != 3){
            throw new IllegalArgumentException("숫자는 3자리 입니다.");
        }

        for(int i=0; i<userNumber.length(); i++){
            char userNumberChar = userNumber.charAt(i);

            if(!Character.isDigit(userNumberChar)){
                throw new IllegalArgumentException("숫자만 입력하세요.");
            }
        }

        for(int i=0; i<userNumber.length(); i++) {
            int userNumberInt = Integer.parseInt(userNumberSplit[i]);

            if (user.contains(userNumberInt)) {
                throw new IllegalArgumentException("중복된 숫자입니다.");
            }

            if (!user.contains(userNumberInt)) {
                user.add(userNumberInt);
            }
        }

        return user;
    }

}
