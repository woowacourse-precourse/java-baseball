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
        Game.strikeAndball_Message();
    }
    public static void strikeAndball_Message() {
        if (User.ball_count() != 0) {
            System.out.print(User.ball_count() + "볼 " );
        }
        if (User.strike_count() != 0) {
            Game.startOrexit();
            System.out.print(User.strike_count() + "스트라이크" + " ");
        }
        Game.nothing_Message();
    }
    public static void nothing_Message(){
        if (User.strike_count() == 0 && User.ball_count() == 0) {
            System.out.print("낫싱" + "\n");
        }
    }
    public static String readLine(){
        String input=Console.readLine();

          if(Utils.redundant_Check(input)) throw new IllegalArgumentException("중복된 숫자가 있습니다.");
          if(Utils.blank_Check(input)) throw new IllegalArgumentException("값을 입력해주세요.");
          if(Utils.length_check(input)){ throw new IllegalArgumentException("3글자 수가 아닙니다.");}
          if(Utils.zeroOrNumber_check(input)){ throw new IllegalArgumentException("1~9숫자를 입력해주세요.");}

          return input;

    }
    public static void startOrexit(){
        if (User.strike_count() == 3) {
            System.out.print(User.strike_count()+"스트라이크" +"\n");
            System.out.print("숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + "\n");
            String s = Console.readLine();
            if (s.equals("1")) {
                Computer.setNumber();
                return;
            }
            if (s.equals("2")) {
                System.out.print("게임 종료");
                EXITSTATUS="exit";
            }
        }
    }

    public static void UserInput_Set(String input) {
        User.setNumber(input);
    }
}
