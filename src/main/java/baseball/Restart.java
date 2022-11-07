package baseball;

import java.util.Scanner;

import static baseball.Game.game;
import static baseball.RandomNum.randomNum;

public class Restart {


    public static void reStart(){

        RandomNum randomNum = new RandomNum();
        Scanner sc = new Scanner(System.in);
        int reStart = sc.nextInt();

        if(reStart == 1){
            System.out.println("숫자 야구 게임을 시작합니다.");
            int[] randomNum2 = randomNum();
            boolean check = false;
            while(!check){
                check = game(randomNum2);
            }
        }else if(reStart == 2){
            System.out.println("게임 종료");
        }else{
            System.out.println("1 또는 2로 입력해주세요.");
        }

        return;
    }
}
