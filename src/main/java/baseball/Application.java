package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = makeNumber();
        List<Integer> user = inputUser();
    }

    public static List<Integer> makeNumber(){
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> inputUser(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int user = Integer.parseInt(input);

        List<Integer> userInput = new ArrayList<>();

        userInput.add(user / 100); //백의 자리
        userInput.add((user/10)%10); // 십의 자리
        userInput.add(user%10); // 일의 자리

        return userInput;
    }
}
