package baseball;

import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        play();
        isNewGame();
    }
    public static void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int min = 100;
        int max = 999;
        String random_string="000";
        while(true){
            int random = (int) ((Math.random() * (max - min)) + min);
            //985
            int first=random/100; //9
            int second=random%100/10; //85 //8
            int third=random%10;
            if(first!=second&&first!=third&&second!=third){
                random_string = String.valueOf(random);
                break;
            }
        }
        guess(random_string);
    }
    public static void guess(String com_num){
        Scanner sc = new Scanner(System.in);
        boolean is_wrong=true;
        HashMap com_map= new HashMap<Integer,String>();
        for(int digits=0;digits<3;digits++){
            com_map.put(digits,com_num.substring(digits,digits+1));
            //System.out.println(comMap);
        }
        while(is_wrong){
            HashMap usr_map= new HashMap<Integer,String>();
            System.out.println("숫자를 입력해주세요 :");
            String usr_num= sc.next();
            for(int digits=0;digits<3;digits++){
                usr_map.put(digits,usr_num.substring(digits,digits+1));
                //System.out.println(usrMap);
            }
            int strike=0;
            int ball=0;
            for(int i=0;i<3;i++){
                //첫째자리 유무
                Object num=com_map.get(i);
                if(usr_map.containsValue(num)){
                    if(usr_map.get(i).equals(num)){
                        //같으면 스트라이크 다르면 볼
                       strike+=1;
                    }else{
                        ball+=1;
                    }
                }
            }

        }
        System.out.println("숫자를 입력해주세요 :");
        String usr_num= sc.next();
    }
    public static void isNewGame(){

    }
}
