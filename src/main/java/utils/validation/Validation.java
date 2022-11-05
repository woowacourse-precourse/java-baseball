package utils.validation;

import java.util.ArrayList;
import java.util.List;

public interface Validation {
    boolean check(String inputValue);

    static Validation isLength(int length){
        return new Validation() {
            @Override
            public boolean check(String inputValue) {
                return inputValue.length() == length;
            }
        };
    }
    static Validation isNumber(){
        return new Validation() {
            @Override
            public boolean check(String inputValue) {
                return inputValue.chars().allMatch(c -> (c >= '1' && c <= '9'));
            }
        };
    }
}
