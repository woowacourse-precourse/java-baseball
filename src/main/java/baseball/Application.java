package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int start = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            start = gameStart();

        } while(start ==1);

        if (start ==2){
            System.exit(0);
        }

    }



    public static int gameStart(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }



        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int start = Integer.parseInt(Console.readLine());

        try{
            if((start ==1) || (start ==2));

        }
        catch(IllegalArgumentException e){
            System.exit(0);
        }

        return start;
    }



}
