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
        if(userInputCharArray.length != 3) throw new IllegalArgumentException();
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
        printResult(ball, strike);
        if(strike == 3)
            return true;
        else
            return false;
    }

    public static void printResult(int ball, int strike){
        if(strike > 0 || ball > 0) {
            if (ball != 0)
                System.out.print(ball + "볼 ");
            if (strike != 0)
                System.out.print(strike + "스트라이크");
            System.out.println();
            if(strike == 3)
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else
            System.out.println("낫싱");
    }

    private static Boolean checkUserContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer userAnswer = Integer.parseInt(Console.readLine());
        switch (userAnswer){
            case 1: return true;
            case 2: return false;
            default: throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = chooseNumByComputer();
        do {
            do {
                user = getUserInput();
            }while(!checkAnswer());
        }while(checkUserContinue());
    }
}
