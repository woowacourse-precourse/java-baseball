package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.sql.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = new ArrayList<>(3);
        List<Integer> user_answer = new ArrayList<>(3);
        getRandomNum(answer);
        getUserAnswer(user_answer);


    }


    public static void getRandomNum(List<Integer> answer){
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public static void getUserAnswer(List<Integer> userAnswer){
        System.out.print("숫자를 입력해주세요 : ");
        try {
            int user_answer = Integer.parseInt(Console.readLine());
            if(user_answer>999 || user_answer<99)
                throw new IllegalArgumentException("입력값 오류");

            for(int i = 2; i >= 0; i--){
                userAnswer.add(user_answer % 10);
                user_answer = user_answer/10;
            }
            Collections.reverse(userAnswer);
        }
        catch (IllegalArgumentException e){
            System.exit(0);
        }



    }



}

