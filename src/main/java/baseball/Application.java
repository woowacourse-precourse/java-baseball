package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List generateNumber() {
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

    public static List inputNumberOfUser() {
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        List<String> stringNumberList = List.of(input.split(""));
        List<Integer> inputNumberList = stringNumberList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        ArrayList<Integer> inputNumberArrayList = new ArrayList<>(inputNumberList);
        Set<Integer> inputNumberSet = new HashSet<>(inputNumberList);
        long count = stringNumberList.stream().filter("0"::equals).count();

        if ((int) (Math.log10(inputNumber) + 1) == 3 && inputNumberSet.size() == 3 && count == 0) {
            System.out.println("숫자를 입력해주세요: " + input);
            System.out.println(inputNumber);
            return inputNumberArrayList;
        } else
            throw new IllegalArgumentException();
    }

    public static int countStrikes(ArrayList<Integer> generatedNumber, ArrayList<Integer> inputNumber) {
        int strike = 0;

        for (int i = 0; i < generatedNumber.size(); i++) {
            if (Objects.equals(generatedNumber.get(i), inputNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int countBalls(ArrayList<Integer> generatedNumber, ArrayList<Integer> inputNumber) {
        int ball = 0;
        if ((Objects.equals(generatedNumber.get(0), inputNumber.get(1))) || Objects.equals(generatedNumber.get(0),
            inputNumber.get(2))) {
            ball++;
        }
        if ((Objects.equals(generatedNumber.get(1), inputNumber.get(0))) || Objects.equals(generatedNumber.get(1),
            inputNumber.get(2))) {
            ball++;
        }
        if ((Objects.equals(generatedNumber.get(2), inputNumber.get(0))) || Objects.equals(generatedNumber.get(2),
            inputNumber.get(1))) {
            ball++;
        }
        return ball;
    }
}
