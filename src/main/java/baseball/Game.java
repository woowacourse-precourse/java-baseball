package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static baseball.Restart.reStart;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class Game {

    public static boolean game(List<Integer> randomNum){

        Restart reStart = new Restart();
        boolean result = false;

        //Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = readLine();

        if(userNum.length() != 3){
            //System.out.println("숫자 3자리만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        /*
        else if(!doubleCheck(userNum)){
            //System.out.println("숫자 중복 없이 입력하시오.");
            throw new IllegalArgumentException();
        }
        //System.out.println("userNum: " + userNum);



         */

        String[] userNumArr = userNum.split("");

        int ball = 0;
        int strike = 0;
        int nothing = 0;
        for(int i = 0; i < randomNum.size(); i++){
            //System.out.println("num: " + userNumArr[i]);
            String userTarget = String.valueOf(randomNum.get(i)); // int -> string 형변환
            if(userNum.contains(userTarget)){
                for(int j = 0; j < userNumArr.length; j++){
                    if(userTarget.equals(userNumArr[j])){
                        if(i == j){
                            strike++;
                        }else{
                            ball++;
                        }
                    }
                }
                //System.out.println(userTarget + "포함되어있음");
            }else{
                nothing++;
            }
        }

        if(strike == 3){
            //System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println(strike + "스트라이크");
            //System.out.println("게임 종료");
            //System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reStart();
            result = true;
        } else if(nothing == 3) {
            System.out.println("낫싱");
        }else if(ball == 0 && strike != 0){
            System.out.println(strike + "스트라이크");
        }else if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return result;
    }

    public static boolean doubleCheck(String nums) {
        String[] num  = nums.split("");

        int count = 0;
        boolean answer = true;
        for(int index = 0; index < 3; index++){
            if(nums.contains(num[index])){
                count++;
            }
            if(count > 1){
                answer = false;
            }
        }

        return answer;
    }

}
