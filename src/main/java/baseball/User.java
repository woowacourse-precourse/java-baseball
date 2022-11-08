package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {


    public String userInput() {
        String inputValue = readLine();

        return inputValidtor(inputValue);
    }

    public String inputValidtor(String inputValue) {


        if (inputValue.length() != 3) {
            throw new IllegalArgumentException("3자리 양식에 맞게 입력하세요");
        }

        if (inputValue.length() == 0){
            throw new IllegalArgumentException("0은 불가능합니다");
        }

        for(int i = 0; i < inputValue.length(); i++){
            if(inputValue.charAt(i) == ' '){
                throw new IllegalArgumentException("공백은 불가능합니다");
            }
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


