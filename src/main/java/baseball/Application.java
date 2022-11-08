package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Integer> computer= new ArrayList<>();
    private static List<Integer> user = new ArrayList<>();
    public static List<Integer> chooseNumByComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        System.out.println(userInput);
        List<Integer> user = new ArrayList<>();
        String[] userInputCharArray = userInput.split("");
        if(userInputCharArray.length > 3) throw new IllegalArgumentException();
        for(String s : userInputCharArray){
            if(user.contains(Integer.parseInt(s))){
                throw new IllegalArgumentException();
            }
            user.add(Integer.parseInt(s));
        }
        return user;
    }

    public static Boolean checkAnswer(){
        int ball = 0;
        int strike = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(user.get(i) == computer.get(i))
                strike ++;
            else if(computer.contains(user.get(i))){
                ball++;
            }
        }
        //결과 출력
        if(strike == 3)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        computer = chooseNumByComputer();
        while (true) {
            user = getUserInput();
            if (checkAnswer()) break;
        }
    }
}
