package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static boolean GoAndStop(String num,int[] UserChoiceNum){
        boolean GoAndStop = true;
        if (num.length() == 3) {
            UserChoiceNum = InputNumber(num);
            //System.out.println(Arrays.toString(UserChoiceNum));
            GoAndStop = true;
        } else if(num.length() !=3){
            //System.out.println("세자리수만 입력가능합니다");
            GoAndStop = false;
        }
        return GoAndStop;
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

    public static HashMap<String,Integer> BallStrike(List<Integer> RandomNumber, int[] UserChoiceNum){
        HashMap<String,Integer> map = new HashMap<>();
        int Ball = 0;
        int Strike = 0;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<UserChoiceNum.length;j++){
                Ball += Ball(RandomNumber.get(i),UserChoiceNum[j],i,j);
                Strike += Strike(RandomNumber.get(i),UserChoiceNum[j],i,j);
            }
        }
        if(Strike == 3){
            map.put("홈런",1);
        } else if (Strike != 3) {
            map.put("볼",Ball);
            map.put("스트라이크",Strike);
        }
        return map;
    }



    public static void main(String[] args) {
        List<Integer> RandomNumber = PickRandomNumber();
        int UserChoiceNum[] = new int[3];
        System.out.println(RandomNumber);
        System.out.println("숫자야구게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요");
        String num = Console.readLine();
        boolean GoAndStop = GoAndStop(num,UserChoiceNum);
        System.out.println(GoAndStop);
        HashMap<String,Integer> result = BallStrike(RandomNumber,UserChoiceNum);
        System.out.println(result.get("볼")+ "볼" + result.get("스트라이크") + "스트라이크");





    }
}
