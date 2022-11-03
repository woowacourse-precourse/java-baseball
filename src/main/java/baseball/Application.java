package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static List<Integer> userInputToList(Integer userInput){
        List userInputList = new ArrayList<>();
        while(userInput > 0){
            userInputList.add(userInput%10);
            userInput /= 10;
        }
        Collections.reverse(userInputList);
        return userInputList;
    }

    public static void checkUserInput(Object userInput){
        try{
            Class userInputClass = userInput.getClass();
            if(userInputClass != Integer.class){
                throw new IllegalArgumentException();
            }

            Integer userInputInteger = Integer.valueOf((int)userInput);
            Set userInputSet = new HashSet(userInputToList(userInputInteger));
            if(userInputSet.size() != 3){
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException occurs");
        }
        catch(Exception e){
            System.out.println("Other Exception occurs");
        }
    }

    public static void main(String[] args) {
        checkUserInput(123);
        // TODO: 프로그램 구현
    }
}
