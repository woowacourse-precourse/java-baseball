package baseball;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static int reDO(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String status = Console.readLine();
        return Integer.parseInt(status);
    }


    public static Boolean isThree(String number){
        if(number.length()==3)
            return true;
        return false;
    }

    public static Boolean isValid(List<Integer> usernumArray){
        if(usernumArray.size() == usernumArray.stream().distinct().count()){
           return true;
        }
        return false;
    }

    public static void checkInput(String number) {
        if (!isThree(number)) {
            throw new IllegalArgumentException();
        }
        if (!isValid(UserNum(number))) {
            throw new IllegalArgumentException();
        }
    }
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

    public static List<Integer> Compare(List<Integer> computer,List<Integer> user){
        int ball =0;
        int strike=0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(computer.get(i)==user.get(j) && i==j)
                    strike++;
                else if (computer.get(i)==user.get(j)&&i!=j){
                    ball++;
                }
            }
        }
        Collections.addAll(result,ball,strike);
        return result;
    }

    public static String gameResult(List<Integer> result){
        if(result.get(0) != 0 && result.get(1) == 0){
            return (result.get(0) + "볼");
        }
        if(result.get(0) == 0 && result.get(1) != 0){
            return (result.get(1) + "스트라이크");
        }
        if(result.get(0) != 0 && result.get(1) != 0){
            return (result.get(0) + "볼 " + result.get(1) + "스트라이크");
        }
        return ("낫싱");
    }

    public static void runGame(){
        List<Integer> computer = RandomNum();
        String result="";
        while(!result.equals("3스트라이크")){
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            checkInput(number);
            result = gameResult(Compare(computer,UserNum(number)));
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int choice = 1;
        while(choice == 1) {
            runGame();
            choice = reDO();
        }
    }
}
