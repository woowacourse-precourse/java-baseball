package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> ComputerNumber = CreatComputer();
        System.out.println("computer = " + ComputerNumber);
        List<Integer> UserNumber = playerNumber();
        System.out.println("UserNumber = " + UserNumber);
        // TODO: 프로그램 구현
    }
    public String FixResult(List<Integer> computer, List<Integer> playerNum){
        int total = AllCount(computer,playerNum);
        int strike = CountStrike(computer,playerNum);
        int ball = total - strike;
        if (total == 0){
            return "낫싱";
        }
        if (strike == 0){
            return ball + "볼";
        }
        if (ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼"+strike+"스트라이크";
    }//총 갯수에서 스트라이크 숫자를 빼서 볼을 출력 그리고 하나도없는경우는 낫싱을 출력
    public int CountStrike(List<Integer> computer, List<Integer> playerNum){
        int strike = 0;
        for (int loop = 0; loop<playerNum.size();loop++){
            if (computer.get(loop)==playerNum.get(loop)){
                strike += 1;
            }
        }
        return strike;
    }//유저와 컴퓨터의 번호를 비교해서 자릿수까지 같은 스트라이크를 구하는기능
    public int AllCount(List<Integer> computer, List<Integer> playerNum){
        int result = 0;
        for (int loop=0;loop<playerNum.size();loop++){
            if (computer.contains(playerNum.get(loop))){
                result +=1;
            }
        }
        return result;
    }//유저와 컴퓨터의 번호의 스트라이크,볼 총갯수 구하는 기능
    public static List<Integer> playerNumber(){
        System.out.println("숫자를 입력해주세요");
        String UserNumber = Console.readLine();
        List<Integer> playerNum = new ArrayList<>();
        for(String number: UserNumber.split("")){
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }//유저 넘버를 입력받고 List<Integer>타입으로 변환
    public static List<Integer> CreatComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }//컴퓨터 랜덤 숫자 생성
        return computer;
    }
}
