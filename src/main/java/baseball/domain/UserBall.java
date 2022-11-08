package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserBall {
    private static final int USER_NUM_LENGTH = 3;
    private static final int ONE = 49;
    private static final int NINE = 57;
    private static final String ERROR_MESSAGE = "올바른 값을 입력하세요";

    private ArrayList<String> inputNumber;
    public ArrayList<Integer> userNumber;

    public void generateUserBall(String inputString){
        inputNumber = new ArrayList<String>();
        userNumber = new ArrayList<Integer>();

        makeUserNumList(inputString);
        validationUserNum(inputNumber);
        toIntegerArray();
    }

    private void makeUserNumList(String inputString){
        for (int i = 0; i < inputString.length(); i++) {
            inputNumber.add(String.valueOf(inputString.charAt(i)));
        }
    }

    private void validationUserNum(List<String> userNumberList){
        checkLength(userNumberList);
        checkOneBetweenNine(userNumberList);
        checkOverlap(userNumberList);
    }

    private void checkLength(List<String> userNumberList){
        if(userNumberList.size() != USER_NUM_LENGTH)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    private void checkOneBetweenNine(List<String> userNumberList){
        for (int i = 0; i < userNumberList.size(); i++){
            int number = userNumberList.get(i).charAt(0);
            if (number < ONE || number > NINE){
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }

    private void checkOverlap(List<String> userNumberList){
        HashSet<String> hashSet = new HashSet<String>(userNumberList);

        if(userNumberList.size() != hashSet.size()){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void toIntegerArray(){
        for (int i = 0; i < USER_NUM_LENGTH; i++){
            userNumber.add(Integer.valueOf(inputNumber.get(i)));
        }
    }
}
