package baseball;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private List<Integer> userNumber;
    public List<Integer> makeUserNumber() {
        System.out.println("숫자를 입력해주세요: ");
        String inputString = readLine();
        List<Integer> inputNumber=new ArrayList<>();
        for(int i=0;i<inputString.length();i++){
            inputNumber.add(inputString.charAt(i)-'0');
        }
        return inputNumber;
    }
}
