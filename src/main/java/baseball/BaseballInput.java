package baseball;

import java.util.List;

public class BaseballInput {

    private int first;
    private int second;
    private int third;


    private void validate(String inputData) {
        String message = "잘못된 입력입니다.";
        try {
            if (inputData.length() != 3) {
                throw new IllegalArgumentException();
            }
            boolean[] chk = new boolean[10];

            for (int i = 0; i < inputData.length(); i++) {
                char currentChar = inputData.charAt(i);
                if (currentChar <= '0' || currentChar > '9') {
                    throw new IllegalArgumentException();
                }
                if (chk[currentChar - '0']) {
                    message = "중복된 수 입력입니다.";
                    throw new IllegalArgumentException();
                }
                chk[currentChar - '0'] = true;
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(message);
        }


    }

    BaseballInput(String inputData) {
        validate(inputData);
        this.first = inputData.charAt(0) - '0';
        this.second = inputData.charAt(1) - '0';
        this.third = inputData.charAt(2) - '0';
    }

    BaseballInput(List<Integer> inputList){
        this.first = inputList.get(0);
        this.second = inputList.get(1);
        this.third = inputList.get(2);
    }

    public boolean isBall(int x){
        return this.first == x || this.second == x || this.third == x;

    }

    public int getStrikeNumber(BaseballInput target){
        int ret = 0;
        if(this.first == target.getFirst())
            ret++;
        if(this.second == target.getSecond())
            ret++;
        if(this.third == target.getThird())
            ret++;
        return ret;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }
}
