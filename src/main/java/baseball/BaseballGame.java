package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void process(){
        System.out.println("게임을 시작합니다.");
        int computer = randomNumberBall();
        System.out.println(computer);
        while(true){
            gamePlay();
            break;
        }
    }

    public static void gamePlay(){
        System.out.print("숫자를 입력하세요 : ");
        String user = Console.readLine();
        if(isValidLength(user) && isValidDiffer(user) && isValidNumber(user)){
            System.out.println(Integer.parseInt(user));
            System.out.println("올바른 값이 입력되었습니다.");
        }
    }

    public static boolean isValidNumber(String user){
        try{
            Integer.parseInt(user);
            return true;
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidDiffer(String user){
        int userNumber = Integer.parseInt(user);

        int first = userNumber/100;
        int second = (userNumber%10)/10;
        int third = userNumber%10;

        if(first-second!=0 && second-third!=0 && third-first!=0){
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidLength(String user) {
        if(user.length()!=3){
            System.out.println("3자리 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }


    public static int randomNumberBall(){
        List<Integer> computer = new ArrayList<>();

        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.get(0)*100 + computer.get(1)*10 + computer.get(2);
    }
}
