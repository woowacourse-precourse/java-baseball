package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {




    public static List<Integer> PickRandomNumber(){
        List<Integer> Number =
                new ArrayList<>();
        while (Number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Number.contains(randomNumber)) {
                Number.add(randomNumber);
            }
        }
        return Number;
    }

    public static int[] GoAndStop(String num,int[] UserChoiceNum){

        if (num.length() == 3) {
            UserChoiceNum = InputNumber(num);
        } else if(num.length() !=3){
           throw new IllegalArgumentException("3자리수만입력가능합니다");
        }
        return UserChoiceNum;
    }
    public static int[] InputNumber(String num){
        int ch[] = new int[3];
        int choice = Integer.parseInt(num);
        for(int j = 2;j>=0;j--){
            ch[j] = choice%10;
            choice = choice/10;
        }
        return ch;
    }

    public static int Ball(int com,int user,int i,int j){
        int ball = 0;
        if((com == user) && i!=j){
            ball = ball+1;
        }
        return ball;
    }

    public static int Strike(int com,int user,int i,int j){
        int strike = 0;
        if((com == user) && i==j){
            strike = strike +1;
        }
        return strike;
    }

    public static HashMap<String,Integer> BallStrike(List<Integer> RandomNumber, int[] UserNum){
        HashMap<String,Integer> map = new HashMap<>();
        int Ball = 0;
        int Strike = 0;
        int Homerun = 0;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<UserNum.length;j++){
                Ball += Ball(RandomNumber.get(i),UserNum[j],i,j);
                Strike += Strike(RandomNumber.get(i),UserNum[j],i,j);
            }
        }
            map.put("볼",Ball);
            map.put("스트라이크",Strike);
        return map;
    }
    public static List<Integer> Restart(int Restart) {
        List<Integer> RandomNumber = new ArrayList<>();
        if (Restart == 0) {
            RandomNumber = PickRandomNumber();
        }
    return RandomNumber;
    }
    public static int HomeRun(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
       
        String choice = Console.readLine();
        if(choice.equals("1")){
            Restart = 0;
        } else if (choice.equals("2")) {
            Restart = 1;
        }
        return Restart;
    }




    public static void main(String[] args) {
        System.out.println("게임을 시작합니다,");

        List<Integer> RandomNumber = new ArrayList<>();
        RandomNumber = PickRandomNumber();
        User: while(RandomNumber.size()>0) {
            System.out.println(RandomNumber);
            int UserChoiceNum[] = new int[3];
            System.out.print("숫자를 입력해주세요");
            String num = Console.readLine();
            int[] UserNum = GoAndStop(num, UserChoiceNum);
            //RandomNumber = CheckResult(RandomNumber,UserNum);
        }
    }
}
