package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answer = getAnswerNum();

        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> guess = inputGuess();

        return;
    }

    public static List<Integer> getAnswerNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputGuess() throws IOException {
        List<Integer> guess = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        for(String i : input){
            guess.add(Integer.parseInt(i));
        }
        return guess;
    }




}
