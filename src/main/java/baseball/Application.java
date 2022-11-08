package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class Generate_Answer_test{
    Practice p;

    @BeforeEach
    void Setup(){
        p = new Practice();
    }


    @Test
    void Generate_Answer_test(){
        List<Integer> result = p.Generate_Answer();

        assertThat(result).size().isEqualTo(3);
        assertThat(result.get(0)).isNotEqualTo(result.get(1)).isNotEqualTo(result.get(2));
        assertThat(result.get(1)).isNotEqualTo(result.get(2));

        for (int i = 0; i>3; i++){
            assertThat(result.get(i)).isBetween(1,9);
        }
    }
}

public class Application {

    static List<Integer> Answer_Numbers = new ArrayList<>();

    public void Start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Generate_Answer();
        Input();
    }
    public void Generate_Answer() {
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

    public void Input() throws IllegalArgumentException {
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

    public HashMap Strike_or_Ball_Judge(List<Integer> Input, List<Integer> Answer) {
        HashMap<String, Integer> Strike_or_Ball = new HashMap<>();
        Strike_or_Ball.put("스트라이크", 0);
        Strike_or_Ball.put("볼", 0);
        for (int Index = 0; Index < 3; Index++) {
            if (Input.get(Index) == Answer.get(Index)) {
                Strike_or_Ball.put("스트라이크", Strike_or_Ball.get("스트라이크") + 1);
            } else if (Input.get(Index) != Answer.get(Index) && Answer.contains(Input.get(Index))) {
                Strike_or_Ball.put("볼", Strike_or_Ball.get("볼") + 1);
            }
        }
        return Strike_or_Ball;
    }

    public void Final_Judge(HashMap<String, Integer> Strike_or_Ball) {
        Integer Strike_Count = Strike_or_Ball.get("스트라이크");
        Integer Ball_Count = Strike_or_Ball.get("볼");

        if (Strike_Count == 0 && Ball_Count == 0) {
            System.out.println("낫싱");
            Input();

        } else if (Strike_Count != 0 && Ball_Count == 0) {
            if (Strike_Count == 3) {
                System.out.println("3스트라이크");
                End();
            } else {
                System.out.printf("%d스트라이크\n", Strike_Count);
                Input();
            }
        } else if (Strike_Count == 0 && Ball_Count != 0) {
            System.out.printf("%d볼\n", Ball_Count);
            Input();
        } else if (Strike_Count != 0 && Ball_Count != 0) {
            System.out.printf("%d볼 %d스트라이크\n", Ball_Count, Strike_Count);
            Input();
        }
    }

    public void End() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int New_Game_or_Finish = Integer.parseInt(Console.readLine());
        if (New_Game_or_Finish == 1) {
            Start();
        } else if (New_Game_or_Finish == 2) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        p.Start();
    }
}