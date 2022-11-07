package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.create();
        application.plyerNuber();

    }

    //컴퓨터 임의의 숫자 3개
    public List<Integer> create() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 숫자= " + computer);
        return computer;
    }

    // 플레이어 입력값
    public List<Integer> plyerNuber() {
        System.out.println("숫자를 입력하세요");
        String userNum = Console.readLine();
        String[] s = userNum.split("");
        List<Integer> playerNum = new ArrayList<>();
        for (int i = 0; i < userNum.length(); i++) {
            playerNum.add(Integer.parseInt(s[i]));
        }
        System.out.println("내 숫자= " + playerNum);
        return playerNum;
    }

    public int check(List<Integer> computer, List<Integer> plyerNuber) {
        int result = 0;
        for (int i = 0; i < plyerNuber.size(); i++) {
            if (computer.contains(plyerNuber.get(i))) {
                result += 1;
            }
        }
        return result;
    }
    public int strike(List<Integer> computer, List<Integer> plyerNuber) {
        int countStrike = 0;
        for (int i = 0; i < plyerNuber.size(); i++) {
            if (computer.get(i) == plyerNuber.get(i)) {
                countStrike += 1;
            }
        }
        return countStrike;
    }

    public String referee(List<Integer> computer, List<Integer> plyerNuber){
        int totalNumber = check(computer,plyerNuber);
        int strikeNumber = strike(computer,plyerNuber);
        int ballNumber = totalNumber - strikeNumber;

        if(totalNumber == 0){
            return "낫싱";
        } else if(strikeNumber==0){
            return ballNumber +"볼";
        } else if(ballNumber==0){
            return strikeNumber + "스트라이크";
        }
         return ballNumber + "볼" + strikeNumber +"스트라이크";
    }
}










