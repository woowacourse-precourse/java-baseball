package features;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Input {
    private static List<Integer> inputNumberRepository = new ArrayList(3);
    private static final int EXCEPTION = -1;

    // 입력 기능
    public static List<Integer> input() {

        Scanner inputNumbers = new Scanner(System.in);

        int threeDigitsNumber = inputNumbers.nextInt();

        // 예외 처리
//        if (threeDigitsNumber < 100||threeDigitsNumber > 999 ) { EXCEPTION; }

//         문자열로 쪼재기
        String numberToString = Integer.toString(threeDigitsNumber);

        // 숫자 쪼개기
        while (threeDigitsNumber > 0){
            inputNumberRepository.add(threeDigitsNumber % 10);
        }

        return inputNumberRepository;
    }
}
