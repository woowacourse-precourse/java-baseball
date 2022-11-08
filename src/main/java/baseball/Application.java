package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> getRandomVal(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> getRtn(List<Integer> computer, String tmp){
        int strike = 0;
        int ball = 0;


        if(tmp.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < tmp.length(); i++){
            int cur = (int)(tmp.charAt(i) - '0');
            if(computer.get(i) == cur){
                strike++;
                continue;
            }else if(computer.contains(cur)){
                ball++;
                continue;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(strike);
        res.add(ball);
        return res;
    }
    public static int validate(int strike,int ball){
        if(strike == 3){
            System.out.printf("3스트라이크\n");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            if(strike == 3){
                System.out.printf("3스트라이크\n");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return 1;
            }
            if(strike == 0 && ball == 0){
                System.out.printf("낫싱\n");
                return 0;
            }
            System.out.printf("%d볼 %d스트라이크\n",ball,strike);
        }
        if(strike == 0 && ball == 0){
            System.out.printf("낫싱\n");
            return 0;
        }
        System.out.printf("%d볼 %d스트라이크\n",ball,strike);
        return 0;
    }
    public static void main(String[] args) throws Exception {

    }
}
