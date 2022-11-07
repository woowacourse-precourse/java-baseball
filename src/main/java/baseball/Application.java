package baseball;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static List<Integer> RandomNum() {
       List <Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> UserNum(String usernum){
        List<Integer> usernumArray = new ArrayList<>();
        for(int i=0; i<usernum.length(); i++)
            usernumArray.add(usernum.charAt(i) - '0');
        return usernumArray;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        System.out.println(UserNum(number));
    }
}
