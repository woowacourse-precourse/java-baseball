package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int answer;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            answer = gameStart();

        } while(answer ==1);

        if (answer ==2){
            System.exit(0);
        }

    }



    public static int gameStart(){
        List<Integer> computer = new ArrayList<>();
        int answer;

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        inputNumber(computer);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        answer = Integer.parseInt(Console.readLine());

        return answer;
    }



    public static void inputNumber(List<Integer> computer){
        List<Integer> user;

        System.out.print("숫자를 입력해주세요 : ");

        try {
            int input = Integer.parseInt(Console.readLine());

            user = splitNumber(input);

            boolean check = new HashSet<>(computer).containsAll(user);

            if (check){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

            if (!check) {

                user = user.stream().distinct().collect(Collectors.toList());

                if (user.size() == 3) {
                    // 비교값과 입력 값 넘겨서 스트라이크, 볼, 낫싱 확인하기
                }
            }
        }catch(IllegalArgumentException e){
            System.exit(0);
        }


    }

    public static List<Integer> splitNumber(int number){
        List<Integer> splitInt = new ArrayList<>();

        int langthNumber = (int)( Math.log10(number) );

        int divide = (int) Math.pow(10,langthNumber);

        while(divide>0){

            splitInt.add(number/divide);

            number %= divide;

            divide /=10;
        }
        return splitInt;
    }



}
