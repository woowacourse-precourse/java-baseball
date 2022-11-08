package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static int input(){
        System.out.println("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(Console.readLine());
        System.out.println(input);
        return input;
    }

    static List<Integer> separate(int input){
        List<Integer> player = new ArrayList<>();
        while(input>0){
            player.add(input%10);
            input = input/10;
        }
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
        List<Integer> computer  = random();
        int inputInt = input();
        List<Integer> player = separate(inputInt);
    }

    static boolean finish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restart = Integer.parseInt(Console.readLine());
        if(restart == 1) return false;
        else if(restart == 2) return true;
        else throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            game();
        }while(!finish());
    }
}
