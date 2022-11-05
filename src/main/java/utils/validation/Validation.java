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

    static Validation isNotDuplicationNumber(){
        return new Validation() {
            @Override
            public boolean check(String inputValue) {
                boolean isNumber = Validation.isNumber().check(inputValue);

                if(isNumber){
                    List<Integer> container = new ArrayList<>();
                    int number = Integer.parseInt(inputValue);

                    int q = number;
                    while(q != 0){
                        int digit = q % 10;

                        if(container.contains(digit)){
                            return false;
                        }else{
                            container.add(digit);
                        }

                        q /= 10;
                    }
                }

                return true;
            }
        };
    }

    static Validation isRange(int start, int end){
        return new Validation() {
            @Override
            public boolean check(String inputValue) {
                boolean isNumber = Validation.isNumber().check(inputValue);

                if(isNumber){
                    int value = Integer.parseInt(inputValue);
                    return start <= value && end >= value;
                }

                return false;
            }
        };
    }
}
