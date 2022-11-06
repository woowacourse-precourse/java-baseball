package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
        String randomString=computer.toString();
        guess(randomString);
    }
    public static void guess(String comNum){
        Scanner sc = new Scanner(System.in);
        boolean isWrong=true;
        HashMap comMap= new HashMap<Integer,String>();
        for(int digits=0;digits<3;digits++){
            comMap.put(digits,comNum.substring(digits,digits+1));
            System.out.println("comMap"+comMap);
        }
        while(isWrong){
            HashMap usrMap= new HashMap<Integer,String>();
            System.out.println("숫자를 입력해주세요 :");
            String usrNum= sc.next();
            if(usrNum.length()>3||usrNum.length()<3){
                throw new IllegalArgumentException("세자리 수가 아닙니다.");
            }
            for(int digits=0;digits<3;digits++){
                usrMap.put(digits,usrNum.substring(digits,digits+1));
                System.out.println("usrMap"+usrMap);
            }
            int strike=0;
            int ball=0;
            for(int i=0;i<3;i++){
                //첫째자리 유무
                Object num=comMap.get(i);
                if(usrMap.containsValue(num)){
                    if(usrMap.get(i).equals(num)){
                        //같으면 스트라이크 다르면 볼
                       strike+=1;
                    }else{
                        ball+=1;
                    }
                }
            }
            if(strike==0&&ball==0){
                System.out.println("낫싱");
            }else if(ball==0) {
                System.out.println(strike+"스트라이크");
                if(strike==3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    return;
                }
            }else if(strike==0){
                System.out.println(ball+"볼");
            }
            else{
                System.out.println(ball+"볼"+" "+strike+"스트라이크");
            }
        }

    }
    public static void isNewGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int isEnd= sc.nextInt();
        if(isEnd==2){
            return;
        }else{
            game();
        }
    }
}
