package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자에게 1 ~ 9까지 중복되지 않는 3개의 숫자를 입력받는다.
        List<Integer> userNumber = userNumList();


    }


    /**
     * 1~9까지 컴퓨터의 수를 랜덤하게 발생시키는 함수이다.
     *
     * @return List<Integer>
     * @date 2022.11.06
     * @author lacred
     */
    public static List<Integer> computerList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 사용자에게 1 ~ 9까지 중복되지 않는 숫자를 입력 받는 함수
     *
     * @return List<Integer>
     * @throws IllegalArgumentException
     * @date 2022.11.07
     * @author lacred
     */
    public static List<Integer> userNumList() {
        List<Integer> userNumber = new ArrayList<>();

        while(userNumber.size()<3){
            Integer userNum = Integer.parseInt(Console.readLine());

            if(userNumber.contains(userNum)){
                System.out.println("중복되는 수를 입력할 수 없습니다. 다시 입력해주세요");
                continue;
            }

            if(userNum > 0 || userNum < 10){
                userNumber.add(userNum);
            }else{
                new IllegalArgumentException("입력은 1 ~ 9까지의 수만 가능합니다.");
            }
        }

        return userNumber;
    }

}
