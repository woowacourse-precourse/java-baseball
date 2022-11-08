package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Application {
    public static void main(String[] args) {
        int run = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(run != 0){
            executionGame();
        }
    }

    public static void executionGame(){
        List<Integer> computerOutput = decision();

        while(true) {
            System.out.print("숫자를 입력해주세요 :");

            List<Integer> user = validation(Console.readLine());

            Integer ball =calculationBall(computerOutput, user);

            Integer strike =calculationStrike(computerOutput, user);

            String result =currentSituation(ball, strike);
            System.out.println(result);
        }
    }
}