package Message;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class Gamerestart {
    public static boolean gamerestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        if(answer.equals("1")){
            return true;
        }
        return false;
    }
}
