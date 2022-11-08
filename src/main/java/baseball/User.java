package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {


    public String userInput() {
        String userInput = readLine();

        return inputValidtor(userInput);
    }

    public static String inputValidtor(String inputValue) {


        if (inputValue.length() != 3) {
            throw new IllegalArgumentException("3자리 양식에 맞게 입력하세요");
        }
        return inputValue;
    }

    public int startAndEnd(String userInputNum){
        if (userInputNum.equals("1")) {
                return 1;

        }

        else if(userInputNum.equals("2")){
                return 2;
        }

        throw new IllegalArgumentException("예외처리");
    }

    public  String restartGame(){
        return readLine();
    }


    public List<Integer> tolistUser(String userIn){

        List<Integer> toList = new ArrayList<>();
        String[] splitone = userIn.split("");

        for(String i : splitone){
            toList.add(Integer.valueOf(i));
        }
        return toList;
    }
}


