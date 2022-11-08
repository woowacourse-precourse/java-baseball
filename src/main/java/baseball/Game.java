package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    static int strike =0;
    static int ball = 0;
    static int [] result = new int[2];
    public static int[] getScore(int randomNumber, int inputNumber){
        int [] answer = new int[3];
        int [] userNumber = new int [3];
        answer[0] = randomNumber/100;
        randomNumber %= 100;
        answer[1] = randomNumber/10;
        randomNumber %= 10;
        answer[2] = randomNumber;

        userNumber[0] = inputNumber/100;
        inputNumber %= 100;
        userNumber[1] = inputNumber/10;
        inputNumber %=10;
        userNumber[2] = inputNumber;
        result[0] = getBall(answer, userNumber);
        result[1] = getStrike(answer, userNumber);
        return result;
    }

    private static int getBall(int[] answer, int[] userNumber) {
        ball =0;
        if(answer[0]==userNumber[1] || answer[0]==userNumber[2]){
            ball++;
        }
        if(answer[1]==userNumber[0] || answer[1]==userNumber[2]){
            ball++;
        }
        if(answer[2]==userNumber[0] || answer[2]==userNumber[1]){
            ball++;
        }
        return ball;
    }

    private static int getStrike(int [] answer, int [] userNumber){
        strike =0;
        for (int i = 0; i < 3; i++) {
            if(answer[i]==userNumber[i]){
                strike++;
            }
        }
        return strike;
    }




}
