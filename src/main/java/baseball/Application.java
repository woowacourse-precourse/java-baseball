package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        List<Integer> computer = new ArrayList<>();

        // 맞출 컴퓨터의 수 생성
        while (computer.size() < 3) {
            int randomNumber = (random.nextInt(9)+1);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            List<Integer> numList = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            int num = sc.nextInt();
            numList = returnList(num);
            System.out.println(numList);
        }
    }

    public static List<Integer> returnList(int num){
        List<Integer> each = new ArrayList<>();
        while(num != 0) {
            each.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(each);
        return each;
    }
    // 받은 숫자를 각 자리수로 짤라서 리스트에 넣음
    public static void checkNum(int num){

    }
}
