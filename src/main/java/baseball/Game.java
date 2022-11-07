package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static baseball.Computer.score;
import static baseball.Restart.reStart;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class Game {

    public static boolean game(List<Integer> randomNum){

        boolean result = false;

        System.out.print("숫자를 입력해주세요 : ");
        String userNum = readLine();

        if(userNum.length() != 3){
            System.out.println("숫자 3자리만 입력해주세요.");
            throw new IllegalArgumentException();
        } else if(!doubleCheck(userNum)){
            System.out.println("숫자 중복 없이 입력하시오.");
            throw new IllegalArgumentException();
        }

        String[] userNumArr = userNum.split("");

        result = score(userNum, randomNum, userNumArr, result);

        return result;
    }

    public static boolean doubleCheck(String nums) {
        String[] num  = nums.split("");

        boolean answer = true;
        if(num[0].equals(num[1]) ||num[0].equals(num[2]) || num[1].equals(num[2])){
            answer = false;
        }
        return answer;
    }

}
