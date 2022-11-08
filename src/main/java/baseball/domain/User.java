package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> user;

    public User() {
        user = new ArrayList<>();
    }

    public Integer stringToInteger(String input){
        return Integer.parseInt(input);
    }

    public List<Integer> numbersToList (int num){

        List<Integer> user = new ArrayList<>();

        while(num > 0){
            user.add(num % 10);
            num /= 10;
        }

        return user;
    }

    public List<Integer> reverseListOrder(List<Integer> numbersToList){
        int lastNumber = numbersToList.get(2);
        numbersToList.set(2, numbersToList.get(0));
        numbersToList.set(0, lastNumber);
        return numbersToList;
    }

    public List<Integer> getUser() {
        return user;
    }
}
