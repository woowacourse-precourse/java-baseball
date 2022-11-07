package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> Answer_Numbers = new ArrayList<>();

    public static void Start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Generate_Answer();
        Input();
    }

    public static void Generate_Answer() {
        if (Answer_Numbers.size() != 0) {
            Answer_Numbers.clear();
        }
        while (Answer_Numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Answer_Numbers.contains(randomNumber)) {
                Answer_Numbers.add(randomNumber);
            }
        }
    }

    public static void Input() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            int Input_Number = Integer.parseInt(Console.readLine());

            int hundreds = Input_Number % 1000 / 100;
            int tens = Input_Number % 100 / 10;
            int units = Input_Number % 10;
            if (Input_Number < 111 || Input_Number > 999) {
                throw new IllegalArgumentException();
            }
            if (hundreds == tens || hundreds == units || tens == units) {
                throw new IllegalArgumentException();
            }
            List<Integer> Input_numbers = new ArrayList<>();
            Input_numbers.add(0, hundreds);
            Input_numbers.add(1, tens);
            Input_numbers.add(2, units);

            Final_Judge(Strike_or_Ball_Judge(Input_numbers, Answer_Numbers));

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {

        // TODO: 프로그램 구현
    }
}
