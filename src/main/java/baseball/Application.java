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
        String result = checkGuess(answer, guess);

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

    public static String checkGuess(List<Integer> answer, List<Integer> guess) throws IOException {
        String check_result = "";
        int ball = 0;
        int strike = 0;

        if(answer.equals(guess)){
            check_result = "3스트라이크";
            return check_result;
        }else{
            int[] cntArray = new int[2];
            cntArray = new int[2];
            ball = cntArray[0];
            strike = cntArray[1];
        }

        //출력문 구현
        if(ball==0&&strike==0){
            check_result = "낫싱";
        }else if(ball==0){
            check_result = strike+"스트라이크";
        }else if(strike==0){
            check_result = ball+"볼";
        }else{
            check_result = ball+"볼 "+strike+"스트라이크";
        }
        return check_result;
    }

    public static




}
