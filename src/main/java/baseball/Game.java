package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    static int strike =0;
    static int ball = 0;
    static ArrayList<Integer> result = new ArrayList<>(2);
    public static ArrayList<Integer> getScore(int randomNumber, int inputNumber){
        ArrayList<Integer> answer = new ArrayList<>(3);
        ArrayList<Integer> userNumber = new ArrayList<>(3);

        answer.clear();
        userNumber.clear();
        result.clear();
        answer.add(randomNumber/100);
        randomNumber %= 100;
        answer.add(randomNumber/10);
        randomNumber %= 10;
        answer.add(randomNumber);
        System.out.println("answer.get(0)"+answer.get(0)+"answer.get(1)"+answer.get(1)+"answer.get(2)"+answer.get(2));

        userNumber.add(inputNumber/100);
        inputNumber %= 100;
        userNumber.add(inputNumber/10);
        inputNumber %=10;
        userNumber.add(inputNumber);
        System.out.println("userNumber.get(0)"+userNumber.get(0)+"userNumber.get(1)"+userNumber.get(1)+"userNumber.get(2)"+userNumber.get(2));

        result.add(getBall(answer,userNumber));
        result.add(getStrike(answer,userNumber));
        System.out.println("result.get(0) = "+result.get(0)+"result.get(1) = "+result.get(1));

        return result;
    }

    private static int getBall(ArrayList<Integer> answer, ArrayList<Integer> userNumber) {
        ball = 0;
        if(answer.get(0)==userNumber.get(1) || answer.get(0)==userNumber.get(2)){
            ball++;
        }
        if(answer.get(1)==userNumber.get(0) || answer.get(1)==userNumber.get(2)){
            ball++;
        }
        if(answer.get(2)==userNumber.get(0) || answer.get(2)==userNumber.get(1)){
            ball++;
        }
        System.out.println("ball "+ ball);
        return ball;
    }

    private static int getStrike(ArrayList<Integer> answer, ArrayList<Integer> userNumber){
        strike =0;
        for (int i = 0; i < 3; i++) {
            if(answer.get(i)==userNumber.get(i)){
                strike++;
            }
        }
        System.out.println("strike "+ strike);
        return strike;
    }




}
