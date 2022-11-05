package baseball;
import java.util.Random;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        //컴퓨터 숫자 선언
        int num=0;

        String str="";
        Random random = new Random();
        for(int i = 0; i < 3; i++) {
            str+=(random.nextInt(9)+1);
        }



        Scanner sc = new Scanner(System.in);

        while(str!=Integer.toString(num)){
            int strike=0;

            System.out.println("숫자를 입력하세요");
            num = sc.nextInt();
            if(str==Integer.toString(num)){
                break;
            }
            String num_str=Integer.toString(num);

            for (int i=0;i<3;i++){
                if(num_str.charAt(i)==str.charAt(i)){
                    strike+=1;
                }
            }
            System.out.println("strike"+strike);

        }



}
}
