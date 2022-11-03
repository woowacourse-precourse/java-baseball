package baseball;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        int randomNumber = makeRandomNumber();
        try {
            int userInput = userInput();
            System.out.println(userInput);
        }catch (IllegalStateException e) {
            System.out.println("IllegalStateException 발생");
            System.out.println("프로그램 종료");
        }
    }


    public static int makeRandomNumber() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = (int) ((Math.random() * 9) + 1);
            numList.add(num);
        }
        return removeRepetitionNumber(numList);
    }

    public static int removeRepetitionNumber(List<Integer> numList) {
        String tmp = "";

        for (int i = 0; i < numList.size()-1; i++) {
            if (numList.get(i) != numList.get(i+1)) tmp += numList.get(i);
        }

        tmp += numList.get(numList.size()-1);
        tmp = tmp.substring(0,3);

        return Integer.parseInt(tmp);
    }


    public static int userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요: ");
        int n = sc.nextInt();

        if (!(n >= 100 && n <1000)) throw new IllegalStateException();

        return n;
    }
}
