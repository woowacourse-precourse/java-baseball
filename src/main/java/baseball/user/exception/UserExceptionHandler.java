package baseball.user.exception;

import baseball.user.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class UserExceptionHandler extends UserService {
    private final Set<Integer> numberSet;

    public UserExceptionHandler(String numberArr) {
        this.numberSet = new HashSet<>();

        try{
            for(int i = 0; i < numberArr.length(); i++) {
                numberSet.add(Character.getNumericValue(numberArr.charAt(i)));
            }
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }
    public void containDuplicateNumber(){
        if(numberSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void containNumberZero(){
        if(numberSet.contains(0)) {
            throw new IllegalArgumentException();
        }
    }


}
