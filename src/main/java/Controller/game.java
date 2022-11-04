package Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Computer;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class game {
    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다");

        game.readLine();
        Computer computer=Computer.getInstance();
        User user= User.getInstance();
        computer.setNumber();
    }
    public static List<Integer> get_ThreeRandomNumbers(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void readLine(){
        System.out.print("숫자를 입력해 주세요 : " );
        String input=Console.readLine();

        User.setNumber(input);
    }
}
