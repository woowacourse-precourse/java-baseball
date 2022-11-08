package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = makeComputer();
        List<Integer> user = inputNumber();
    }

    public static List<Integer> makeComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputNumber(){
        List<Integer> li = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();

        isCorrectType("^[1-9]{3}$", str);
        isDuplication(str);

        for(int i = 0; i < 3; i++){
            int tmp = str.charAt(i) - '0';
            li.add(tmp);
        }
        return li;
    }

    public static void isCorrectType(String pattern, String str){
        boolean result = Pattern.matches(pattern, str);

        if(!result){
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplication(String str) {
        Set<Character> hs = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (hs.contains(c)) {
                throw new IllegalArgumentException();
            }
            hs.add(c);
        }
    }
}
