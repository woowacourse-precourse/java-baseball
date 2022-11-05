package Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Computer;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void start(){
        Game.printMessage(Game.readLine());
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
            Game.nothing_Message();

        System.out.print("\n");

    }
    public static void nothing_Message(){
        System.out.print("낫싱");
    }
    public static String readLine(){
        System.out.print("숫자를 입력해 주세요 : " );
        String input=Console.readLine();

        if(Utils.redundant_Check(input)) throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        if(Utils.blank_Check(input)) throw new IllegalArgumentException("값을 입력해주세요.");
        if(Utils.length_check(input)) throw new IllegalArgumentException("3글자 수가 아닙니다.");
        if(Utils.zeroOrNumber_check(input)) throw new IllegalArgumentException("1~9숫자를 입력해주세요.");
        return input;

    }

    public static void printMessage(String input) {
        User.setNumber(input);
        //정답 체크 메서드 자리
        Game.strikeAndball_Message();
    }
}
