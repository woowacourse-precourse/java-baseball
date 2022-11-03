package features;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Input {
    private static List<Integer> inputNumberRepository = new ArrayList(3);
    private static final int EXCEPTION = -1;

    // 입력 기능
    public static List<Integer> input() {

        Scanner inputNumbers = new Scanner(System.in);
        int inputEachNumber = inputNumbers.nextInt();

        for (Integer integer : inputNumberRepository) {
            inputNumberRepository.add(inputEachNumber);

            if (inputNumberRepository.size()>3) { inputNumberRepository.add(EXCEPTION); }

        }
        return inputNumberRepository;
    }
}
