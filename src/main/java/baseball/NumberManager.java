package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {

    private int[] randomNumberArray;

    public void setRandomNumber() {

        StringBuilder randomNumber = new StringBuilder();

        while(randomNumber.length() < 3) {

            int pickedNumber = Randoms.pickNumberInRange(1, 9);

            if(randomNumber.indexOf(String.valueOf(pickedNumber)) == -1) {
                randomNumber.append(pickedNumber);
            }
        }

        randomNumberArray = convertToNumberArray(randomNumber);

    }

    private int[] convertToNumberArray(StringBuilder number) {

        int[] numberArray = new int[10];

        for (int i = 0; i < number.length(); i++) {
            numberArray[number.charAt(i) - '0'] = i + 1;
        }

        return numberArray;
    }
}
