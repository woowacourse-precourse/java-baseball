package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean result = false;
        boolean win = true;
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.makeRandomNumber();
        List<Integer> com = computerNumber.getComputerNumber();
        for (Integer integer : com) {
            System.out.println("integer = " + integer);
        }


        do {
            UserNumber userNumber = new UserNumber();
            userNumber.makeUserNumber();
            List<Integer> user = userNumber.getUserNumber();
            if (com.equals(user)) {
                System.out.println("승리");
                win = false;
            }
        }while (win);
    }
}
