package baseball;
import camp.nextstep.edu.missionutils.Console;

public class TryAgain {
    String tryAgainOrNot;

    public boolean tryAgainOrWhat() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        tryAgainOrNot = Console.readLine();
        char answer = tryAgainOrNot.charAt(0);
        if(answer == '1') {
            return true;
        }
        return false;
    }



}
