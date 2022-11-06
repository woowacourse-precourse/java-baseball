package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameStarter {
    private static Integer strike;
    private Integer ball;
    private List<Integer> user;
    private List<Integer> computer;

    //잘못된 입력을 받을 경우
    public void IllegalInput(List<Integer> input) {
        //입력이 3자리의 숫자가 아님
        if(input.size()!=3){
            throw new IllegalArgumentException("3자리의 수를 입력하세요.");
        }
        //서로 다른 3자리의 숫자가 아닌 경우
        if(Objects.equals(input.get(0), input.get(1)) || Objects.equals(input.get(0), input.get(2)) || Objects.equals(input.get(1), input.get(2))){
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }
    }

    //랜덤값을 추출
    public List<Integer> RandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //user에게 값을 받음
    public List<Integer> InputNum(){
        List<Integer> user = new ArrayList<>();
        String[] userInput = Console.readLine().split("");
        for(int i=0; i<userInput.length; i++){
            user.add(Integer.parseInt(userInput[i]));
        }
        IllegalInput(user);
        return user;
    }

    //입력된 값과 정답이 일치하는지 확인
    public String solution(List<Integer> input){
        String answer = "";
        this.strike = 0;
        this.ball = 0;
        for(int i=0; i<3; i++){
            if(input.get(i)==arr[i]) strike++;
        }
        for(int i=0; i<3; i++){
            if(input.contains(arr[i])&&input.get(i)!=arr[i]){
                ball++;
            }
        }
        if(strike == 0 && ball == 0){
            answer = "낫싱";
        }
        if(ball != 0 && strike != 0){
            answer = ball + "볼 " + strike + "스트라이크";
        }
        if(ball == 0 && strike != 0){
            answer = strike + "스트라이크";
        }
        if(ball != 0 && strike == 0){
            answer = ball + "볼";
        }
        System.out.println(answer);
        return answer;
    }

    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static boolean endCheck(){
        if (strike != null && strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
            String res = Console.readLine();
            if (res.equals("1")) {
                return true;
            }
            if (res.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
        }
        return true;}
}
