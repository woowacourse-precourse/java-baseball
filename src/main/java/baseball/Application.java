package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int com1, com2, com3;
        while(true) {
            //1~9사이의 난수생성
            com1 = random.nextInt(100) % 9 + 1;
            com2 = random.nextInt(100) % 9 + 1;
            com3 = random.nextInt(100) % 9 + 1;
            if(!(com1==com2 || com2==com3 || com3==com1)) {
                //중복되지 않는 난수 생성에 성공하면 루프탈출
                break;
            }
        }
        //난수확인
        System.out.println(com1+" "+com2+" "+com3);
        System.out.println("숫자 야구 게임을 시작합니다.");
//        while(true){
//            System.out.print("숫자를 입력해주세요 : ");
//            int num = sc.nextInt();
//            checkNum(num);
//        }
        checkNum(123);
    }

    public static void checkNum(int num){
        ArrayList<Integer> each = new ArrayList<>();
        while(num != 0) {
            each.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(each);
        System.out.println(each);
    }
}
