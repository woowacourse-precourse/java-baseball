package baseball.model;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Computer {
    private int ballCount = 0;
    private int strikeCount = 0;
    private int[] numbers = new int[3];

    public void generateNumber(){
        do {
            numbers = pickNumbers();
        } while (Util.isDuplicated(numbers));

    }

    public int[] pickNumbers(){
        return Arrays.stream(new int[3])
                .map(num -> Randoms.pickNumberInRange(1, 9))
                .toArray();
    }

    public void compare(int[] guessNumbers) {
        for (int i = 0; i < numbers.length; i++){
            search(guessNumbers[i], i);
        }

    }


    private void search(int guessNumber, int index){

        if (guessNumber == numbers[index]){
            strikeCount++;
            return;
        }

        for(int i = 0; i < numbers.length; i++){
            if (guessNumber == numbers[i]){
                ballCount++;
            }
        }
    }
}
