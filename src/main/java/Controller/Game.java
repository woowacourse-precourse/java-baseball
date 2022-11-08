package Controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Computer;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static String EXITSTATUS="playing";

    public static void start(){
        System.out.print("숫자를 입력해주세요 : ");
        Game.UserInput_Set(Game.readLine());
        Game.print_Message();
    }
    public static void print_Message() {
        Game.ball_Message();
        Game.strike_Message();
        Game.nothing_Message();
    }
    public static void strike_Message(){
        if (User.strike_count() != 0) {
            Game.startOrexit();
            System.out.print(User.strike_count() + "스트라이크" + " ");
        }
    }
    public static void ball_Message(){
        if (User.ball_count() != 0) {
            System.out.print(User.ball_count() + "볼 " );
        }
    }
    public static void nothing_Message(){
        if (User.strike_count() == 0 && User.ball_count() == 0) {
            System.out.print("낫싱" + "\n");
        }
    }
    public static String readLine(){
        String input=Console.readLine();
        Utils.check_input(input);
        return input;

    }
    public static void startOrexit(){
        if (User.strike_count() == 3) {
            whenCorrect_Message();
            set_EXITSTATUS(Console.readLine());
        }
    }
    public static void whenCorrect_Message(){

        System.out.print(User.strike_count()+"스트라이크" +"\n");
        System.out.print("숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + "\n");
    }

    public static void set_EXITSTATUS(String input) {
        if (input.equals("1")) {
            Computer.setNumber();
            return;
        }
        if (input.equals("2")) {
            System.out.print("게임 종료");
            EXITSTATUS="exit";
        }
    }

    public static void UserInput_Set(String input) {
        User.setNumber(input);
    }
}
