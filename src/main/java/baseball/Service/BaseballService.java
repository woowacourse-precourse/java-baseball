package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private static final int NUMBER_SIZE=3;
    private static final int RANGE_START=1;
    private static final int RANGE_END=9;
    private static final int RESTART=1;
    private static final int END=2;


    public List<String> createRandomNumber(){

        List<String> computerNumber = new ArrayList<>();

        for(int i=0; i<NUMBER_SIZE; i++) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));
            isDuplicate(computerNumber, number);
            computerNumber.add(number);
        }

        return computerNumber;
    }


    public void isValidInputSize(List<String> inputNumber) {
        if (inputNumber.size()!=NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }


    public void isValidInputRange(List<String> inputNumber) {
        for(String input: inputNumber) {
            int number = Integer.parseInt(input);
            if (number < RANGE_START || RANGE_END > 9) {
                throw new IllegalArgumentException();
            }
        }
    }


    public void isDuplicate(List<String> inputNumber, String number) {
        if (inputNumber.contains(number)) {
            throw new IllegalArgumentException();
        }
    }


    public void isValidNumber(int number) {
        if (number!=RESTART && number!=END) {
            throw new IllegalArgumentException();
        }
    }

}
