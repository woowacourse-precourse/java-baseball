package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> input(){
        List<Integer> player = new ArrayList<>();
        return player;
    }

    static List<Integer> random(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void game(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> player = new ArrayList<>();
        computer = random();
        player = input();

    }
    static boolean finish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            int restart = Integer.parseInt(Console.readLine());
            if(restart == 1) return false;
            else if(restart == 2) return true;
        }catch(Exception e) {}
        return true;
    }
    public static void main(String[] args) {

        do{
            game();
        }while(!finish());
    }
}
