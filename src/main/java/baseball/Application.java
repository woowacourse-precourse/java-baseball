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
        System.out.println("맞출 수 : " + computer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            int num = sc.nextInt();
            List<Integer> numList = returnList(num);
            checkNum(computer, numList);
        }
    }

    // 받은 숫자를 각 자리수로 짤라서 리스트에 넣음
    public static List<Integer> returnList(int num){
        List<Integer> each = new ArrayList<>();
        while(num != 0) {
            each.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(each);
        return each;
    }

    // 숫자 스트라이크/볼 체크
    public static void checkNum(List<Integer> computer, List<Integer> my){
        Scanner sc = new Scanner(System.in);
        int s = 0;
        int b = 0;
        if (computer.get(0) == my.get(0) && computer.get(1) == my.get(1) && computer.get(2) == my.get(2)){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            //int result = sc.nextInt();
        }

        for (int i = 0; i < computer.size(); i++){
            if (computer.contains(my.get(i)) && computer.get(i) == my.get(i)){
                s++;
            } else if (computer.contains(my.get(i))) {
                b++;
            }
        }

        if (s == 0 && b == 0)
            System.out.println("낫싱");
        else if (s == 0) {
            System.out.println(b + "볼");
        } else if (b == 0) {
            System.out.println(s + "스트라이크");
        }else {
            System.out.println(b + "볼 " + s + "스트라이크");
        }
    }
}
