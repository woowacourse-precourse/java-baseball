package baseball;

import java.util.*;

public class Application {
    public static int StartGame(String computerNum, Scanner scan){
        int repeat;
        String num;
        int result;

        while (true) {
            num = Inputnum.InsertNum(scan);
            if (Exception.exception(num) == false)
                throw new IllegalArgumentException();
            result = CheckNumber.CheckNum(num, computerNum);
            if (result == 1){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
                repeat = AskRepeatGame.askReGame(scan);
                break;
            }
        }
        return repeat;
    }
    public static void main(String[] args) {
        int repeat = 1;
        Scanner scan = new Scanner(System.in);
        String computerNum;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (repeat == 1){
            List<Integer> computer = new ArrayList<>();

            computer = Inputnum.Randomnum();
            computerNum = Inputnum.changeString(computer);
            repeat = StartGame(computerNum, scan);
        }
    }
}