package baseball;

import java.util.HashMap;
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
        int min = 100;
        int max = 999;
        String randomString="000";
        while(true){
            int random = (int) ((Math.random() * (max - min)) + min);
            //985
            int first=random/100; //9
            int second=random%100/10; //85 //8
            int third=random%10;
            if(first!=second&&first!=third&&second!=third){
                randomString = String.valueOf(random);
                break;
            }
        }
        guess(randomString);
    }
    public static void guess(String comNum){
        Scanner sc = new Scanner(System.in);
        boolean isWrong=true;
        HashMap comMap= new HashMap<Integer,String>();
        for(int digits=0;digits<3;digits++){
            comMap.put(digits,comNum.substring(digits,digits+1));
           // System.out.println(comMap);
        }
        while(isWrong){
            HashMap usrMap= new HashMap<Integer,String>();
            System.out.println("숫자를 입력해주세요 :");
            String usrNum= sc.next();
            for(int digits=0;digits<3;digits++){
                usrMap.put(digits,usrNum.substring(digits,digits+1));
                //System.out.println(usrMap);
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
