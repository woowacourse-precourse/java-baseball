package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        if(generateNumbers().get(1) == inputNumberOfUser().get(1)) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }

    public static List generateNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    public static ArrayList inputNumberOfUser() {
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        List<String> stringNumberList = List.of(input.split(""));
        List<Integer> inputNumberList = stringNumberList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        ArrayList<Integer> inputNumberArrayList = new ArrayList<>(inputNumberList);
        Set<Integer> inputNumberSet = new HashSet<>(inputNumberList);
        long count = stringNumberList.stream().filter("0"::equals).count();

        if((int)(Math.log10(inputNumber)+1) == 3 && inputNumberSet.size() == 3 && count == 0) {
            System.out.println("숫자를 입력해주세요: " + input);
            System.out.println(inputNumberList);
            return inputNumberArrayList;
        } else
            throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

//    public static void countStrike() {
//        int i = 0;
//        int strike = 0;
//        while(true) {
//
//            }
//        }
//    }
}
