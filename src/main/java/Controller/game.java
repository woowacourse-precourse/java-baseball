package Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Computer;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class game {
    public static void start(){
        game.printMessage(game.readLine());
    }
    public static void strikeAndball_Message(){
        int strike_count=0;
        int ball_count=0;
        for(int index=0; index<3; index++) {
            if(Computer.getNumber().charAt(index)==User.getNumber().charAt(index)){
                strike_count++;
                continue;
            }
            if(Computer.getNumber_List().contains(Character.getNumericValue((User.getNumber().charAt(index))))) {
                ball_count++;
            }
        }
        if(strike_count!=0) {
            System.out.print(strike_count + "스트라이크" + " ");
        }
        if(ball_count!=0) {
            System.out.print(ball_count + "볼");
        }
        if(strike_count==0&&ball_count==0)
            game.nothing_Message();

        System.out.print("\n");

    }

    public static void nothing_Message(){
        System.out.print("낫싱");
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

    public static String readLine(){
        System.out.print("숫자를 입력해 주세요 : " );
        String input=Console.readLine();
        return input;

    }

    public static void printMessage(String input) {
        User.setNumber(input);
        game.strikeAndball_Message();
    }
}
