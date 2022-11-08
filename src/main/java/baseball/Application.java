package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static List<Integer> generateThreeDifferentNum() {
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
     *  플레이어의 입력값이 1~9사이 서로다른 3가지 숫자인지 확인
     *
     * @param playerInput Console.readLine()에서 받은 String 값
     * */
    public static void isDifferentThreeNum(String playerInput){
        List<String> playerInputArray = Arrays.asList(playerInput.split(""));
        Set<String> delSameNum = new HashSet<String>(playerInputArray);
        boolean isOneToNineAndSizeThree = Pattern.matches("^[1-9]{3}$", playerInput);
        boolean isNoOverlap = playerInputArray.size() == delSameNum.size();

        if (!(isOneToNineAndSizeThree && isNoOverlap)) {
            throw new IllegalArgumentException();
        }
    }


    public static void main(String[] args) {
        List<Integer> computer = generateThreeDifferentNum();
        String playerInput = Console.readLine();
    }
}
