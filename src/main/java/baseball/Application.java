package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomNumber = getRandomNumber();

        while (true)
        {
            List<Integer> inputNumber = makeUserNumber();

        }

    }


    private static List<Integer> getRandomNumber()
    {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> makeUserNumber(){

        List<Integer> inputNumber = new ArrayList<>();
        String consoleInputNumber = Console.readLine();

        for(int i =0 ; i < 3; i++)
        {
            Integer number = Integer.parseInt(String.valueOf(consoleInputNumber.charAt(i)));
            // 같은 숫자를 입력한 예외 케이스 체크
            if(inputNumber.contains(number))
            {
                throw new IllegalArgumentException("같은 숫자를 입력했습니다.");
            }

            inputNumber.add(number);
        }

        return inputNumber;

    }
}
