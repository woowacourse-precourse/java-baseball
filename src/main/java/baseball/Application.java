package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = makeNumber();
        ArrayList<Integer> user = userNumber();
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

    public static int inputUser(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if(input.length() !=3){
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");
        }

        if(input.contains("0")){
            throw new IllegalArgumentException("1~9만 입력하세요");
        }

        for(int duplicate=0; duplicate<input.length(); duplicate++){
            if(input.indexOf(input.charAt(duplicate)) != duplicate){
                throw new IllegalArgumentException("서로 다른 수를 입력하세요");
            }
        }

        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> userNumber(){
        int user = inputUser();

        ArrayList<Integer> userInput = new ArrayList<>(3);

        while(user != 0){
            userInput.add(user%10);
            user /= 10;
        }
        Collections.reverse(userInput);

        return userInput;
    }
}
