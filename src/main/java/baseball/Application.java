package baseball;
import java.util.*;
public class Application {
    public static String getResult(int[] cNum, int pNum){
        return "";
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("Let's");
        Scanner sc=new Scanner(System.in);
        while(true){
            int[] comNum=new int[3];
            for(int i=0;i<comNum.length;i++){
                comNum[i]=(int)(Math.random()*9)+1;
            }


        }
    }
}
