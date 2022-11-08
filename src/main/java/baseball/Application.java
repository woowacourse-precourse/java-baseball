package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
    public static int baseball_event(){
        System.out.println("숫자를 입력해주세요 :");
        List<Integer> computer = getRandomVal(); //3자리씩 끊어가져와
        while (true) {
            List<Integer> res = getRtn(computer,Console.readLine());
            int strike = res.get(0);
            int ball = res.get(1);
            if(validate(strike,ball) == 1) break;
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String n = Console.readLine();
        if(n.length() != 1) throw new IllegalArgumentException();
        if(n.equals("2")){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        
    }
}
