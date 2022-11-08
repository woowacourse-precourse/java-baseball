package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Collections;

public class Score {
    static int strike =0;
    static int ball = 0;
    static ArrayList<Integer> result = new ArrayList<>(2);
    public static ArrayList<Integer> check (int randomNumber, int inputNumber){
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

        userNumber.add(inputNumber/100);
        inputNumber %= 100;
        userNumber.add(inputNumber/10);
        inputNumber %=10;
        userNumber.add(inputNumber);

        result.add(getBall(answer,userNumber));
        result.add(getStrike(answer,userNumber));


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
        return ball;
    }

    private static int getStrike(ArrayList<Integer> answer, ArrayList<Integer> userNumber){
        strike =0;
        for (int i = 0; i < 3; i++) {
            if(answer.get(i)==userNumber.get(i)){
                strike++;
            }
        }
        return strike;
    }

    public static void getMessage(ArrayList<Integer> result) {
        if(result.get(0)!=0 && result.get(1)==0){
            System.out.println(result.get(0) + "볼");
        }
        if(result.get(0)!=0 && result.get(1)!=0){
            System.out.println(result.get(0) + "볼 "+result.get(1)+"스트라이크");
        }
        if(result.get(0)==0 && result.get(1)!=0){
            System.out.println(result.get(1) + "스트라이크");
        }
        if(result.get(0)==0 && result.get(1)==0){
            System.out.println("낫싱");
        }
    }




}
