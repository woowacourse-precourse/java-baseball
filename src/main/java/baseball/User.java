package baseball;

public class User {


    public static String inputValidtor(String inputValue) throws IllegalArgumentException{



        if(inputValue.length() != 3){
            throw new IllegalArgumentException("3자리 양식에 맞게 입력하세요");
        }
        return inputValue;
    }

}
