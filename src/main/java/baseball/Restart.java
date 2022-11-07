package baseball;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.controller.GameController.game;
import static baseball.domain.Computer.randomNum;

public class Restart {


    public static void reStart(){

        Computer randomNum = new Computer();
        String reStart = Console.readLine();

        if(reStart.equals("1")){
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> randomNum2 = randomNum();
            boolean check = false;
            while(!check){
                check = game(randomNum2);
            }
        }else if(reStart.equals("2")){
            System.out.println("게임 종료");
        }else{
            System.out.println("1 또는 2로 입력해주세요.");
        }

        return;
    }
}
