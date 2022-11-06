package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Application {

    static int hundred, ten, one;
    static boolean correct_num(int n) {
        boolean result = false;

        hundred = n / 100;
        ten = (n % 100) / 10;
        one = n % 10;

        if((hundred != ten) && (ten != one) && (one != hundred)) {
            result = true;
        }

        return result;
    }
    public static void main(String[] args) throws IOException, IllegalArgumentException{
        // TODO: 프로그램 구현
        // Create
        Random Randoms = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Random Computer Number
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.nextInt(9)+1;
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // Input
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        int n = Integer.parseInt(br.readLine());

        // Exception
        if(0 > n && n > 999) {
            throw new IllegalArgumentException("1~999사이의 숫자를 입력해주세요.");
        }

        // is Correct Number
        boolean c = correct_num(n);
        if(c == true) {
            System.out.println(n + "is correct number");
        }
    }
}
