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
        boolean game_on = true;
        List<Integer> answer = getAnswerNum();

        while(game_on==true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> guess = inputGuess();

            String result = checkGuess(answer, guess);
            System.out.println(result);
            if (result.equals("3스트라이크")){
                game_on = endGame();
                if(game_on == true) answer = getAnswerNum();
            }else{ continue; }
        }
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
            cntArray = cntBallStrike(answer, guess);
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

    public static int[] cntBallStrike(List<Integer> answer, List<Integer> guess){
        int[] cnt = new int[2];    /*cnt[0]는 ball, cnt[1]는 strike*/

        for(Integer guess_num : guess){
            if(answer.contains(guess_num)){
                cnt[0]++;
            }
            if(answer.indexOf(guess_num)==guess.indexOf(guess_num)){
                cnt[0]--;
                cnt[1]++;
            }
        }
        return cnt;
    }

    public static boolean endGame() throws IOException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.equals("1")){
            return true;
        }else if(input.equals("2")){
            return false;
        }else return endGame();
    }

}
