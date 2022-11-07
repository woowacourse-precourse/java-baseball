package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> computernumber = new ArrayList<>();
    public static void checkstrikeball(List<Integer> personnumber){
        int strikecount=0;
        int ballcount=0;
        for(int i=0;i<3;i++){
            if(personnumber.get(i)==computernumber.get(i)){
                strikecount++;
            }else if(computernumber.contains(personnumber.get(i))){
                ballcount++;
            }
        }

    }

    public static void tellresult(int strikecount, int ballcount){
        if(strikecount==3){
            System.out.println(strikecount+"스트라이크");
        }
        if(strikecount==0&&ballcount==0){
            System.out.println("낫씽");
        }
        if(strikecount==0){
            System.out.println(ballcount+"볼");
        }
        if(ballcount==0){
            System.out.println(strikecount+"스트라이크");
        }
        System.out.println(ballcount+"볼 "+strikecount+"스트라이크");
    }

    public static void enternumber(){
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner sc=new Scanner(System.in);
        List<Integer> playernumber=new ArrayList<>();
        String number=sc.next();
        for(int i=0;i<3;i++){
            playernumber.add(Integer.parseInt(number.substring(i,i+1)));
        }
        checkstrikeball(playernumber);
    }

    public static void resetorend(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc=new Scanner(System.in);
        int playeranwer=sc.nextInt();
        if(playeranwer==1){
            enternumber();
        }else if(playeranwer==2){
            return;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
