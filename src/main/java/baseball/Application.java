package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
       game();
    }
    public static void game(){
        play();
        isNewGame();
    }
    public static void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        guess(computer);
    }
    public static void guess(List<Integer> comNum){
        boolean isWrong=true;
        HashMap comMap= new HashMap<Integer,String>();

        for(int digits=0;digits<3;digits++){
            comMap.put(digits,String.valueOf(comNum.get(digits)));
        }

        while(isWrong){
            HashMap usrMap= new HashMap<Integer,String>();
            System.out.println("숫자를 입력해주세요 :");
            String usrNum= Console.readLine();

            if(usrNum.length()>3||usrNum.length()<3){
                throw new IllegalArgumentException("세자리 수가 아닙니다.");
            }

            for(int digits=0;digits<3;digits++){
                usrMap.put(digits,usrNum.substring(digits,digits+1));
            }


            List<Integer> countBandS = new ArrayList<>();
            countBandS=ballAndStrike(comMap,usrMap);

            int ball=countBandS.get(0);
            int strike=countBandS.get(1);

            if(strike==0&&ball==0){
                System.out.println("낫싱");
            }else if(ball==0&&strike==3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }else if(ball==0){
                System.out.println(strike+"스트라이크");
            }else if(strike==0){
                System.out.println(ball+"볼");
            }
            else{
                System.out.println(ball+"볼"+" "+strike+"스트라이크");
            }
        }

    }
    public static void isNewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int isEnd= Integer.valueOf(Console.readLine());
        if(isEnd==2){
            return;
        }else{
            game();
        }
    }
    public static List<Integer> ballAndStrike(HashMap<Integer,String> comMap,HashMap<Integer,String> usrMap){
        List<Integer> countBandS = new ArrayList<>();
        int strike=0;
        int ball=0;

        for(int digits=0;digits<3;digits++){
            Object num=comMap.get(digits);
            if(usrMap.containsValue(num)&&usrMap.get(digits).equals(num)){
                strike+=1;
            }else if(usrMap.containsValue(num)){
                ball+=1;
            }
        }

        countBandS.add(ball);
        countBandS.add(strike);
        return countBandS;
    }
}
