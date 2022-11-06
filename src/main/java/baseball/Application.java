package baseball;

import java.util.*;

//camp.nextstep.edu.missionutils is provided by pre-course admin
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int strike, ball;
    public static void main(String[] args) {
        List<Integer> Computer = new ArrayList<>();
        List<Integer> User = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        //if continue signal received, keep playing game
        while(Continue_or_End()){
            MakeAnswer(Computer);
            StartGame(User, Computer);
        }
    }

    private static void err_check(List<Integer> User){
        Set<Integer> set = new HashSet<>(User);
        if(set.size() != User.size()) 
            throw new IllegalArgumentException("각 자릿수는 서로 다른 숫자만 입력 가능합니다.");
        else if(User.contains(0))
             throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        else if(User.size() != 3) 
            throw new IllegalArgumentException("오직 세 자리의 숫자만 입력 가능합니다.");
    }
    
    private static void MakeAnswer(List<Integer> Computer){
        for(int i = 0; i < Computer.size(); i++){
            int number = Randoms.pickNumberInRange(1, 9);
            if(Computer.contains(number)) 
                i--;
            else Computer.add(number);
        }
    }

}
