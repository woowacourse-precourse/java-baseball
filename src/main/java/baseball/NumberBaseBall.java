package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class NumberBaseBall {
    boolean GameStart(List<Integer> computerNumList) {
        while (true) {
            /**
             * player 숫자 입력받음 */
            int playerNum = Integer.parseInt(Console.readLine());

            /**
             * 자릿수 나누기 */
            List<Integer> playerNumList = numberDigits(playerNum);
            /**
             * player 숫자가 로직에 벗어나는지체크
             * */
            NumberLogicCheck(playerNumList);
            

        }
    }
    // 숫자 로직 체크
    void NumberLogicCheck(List<Integer> list){
        if (list.size() != 3) {
            System.out.println("입력한 숫자의 자릿수를 확인하세요.");
            throw new IllegalArgumentException();
        }
        if (list.size() != list.stream().distinct().count()){
            System.out.println("중복되는 숫자를 확인하세요");
            throw new IllegalArgumentException();
        }
    }

    // 자릿수 나누기
    List<Integer> numberDigits(int number) {
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            int div = number % 10;
            list.add(div);
            number = number / 10;
        }
        Collections.reverse((list));
        return list;
    }
}
