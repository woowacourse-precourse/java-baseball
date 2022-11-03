package baseball;

import java.util.ArrayList;
import java.util.List;

public class SetPlay {
    public static void startGame(){
        List<Integer> computer = new ArrayList<Integer>();
        Computer.CreateRandomNum(computer);

        run(computer);
    }

    public static void run(List<Integer> computer){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        Playing.compare(User.inputNum(), computer);
    }
}
