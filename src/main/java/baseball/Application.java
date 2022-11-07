package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 기능 목록
 *  - executionGame : 하나의 게임 단위
 *  - continueGame :  게임을 새로 시작할지 종료할지 결정하는 함수
 *  - decision : 서로 다른 3개의 랜덤 수 저장
 *  - validationAndConvert : 입력에 대한 검증과 List<Integer>로 반환
 *  - calculationBall : 볼 계산
 *  - calculationStrike : 스트라이크 계산
 *  - currentSituation : 입력에 대한 결과를 문자열 형태로 반환
 *  - isCorrect : 정답을 맞추었는지
 */
public class Application {
    public static void main(String[] args) {

        int code = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(code != 0){
            executionGame();
            code = continueGame();
        }

    }
    public static Integer continueGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(Console.readLine().equals("2"))return 0;
        else return 1;
    }
    public static void executionGame(){
        List<Integer> computer = decision();

        while(true) {
            System.out.print("숫자를 입력해주세요 :");

            List<Integer> user = validationAndConvert(Console.readLine());

            Integer ball = calculationBall(computer, user);

            Integer strike = calculationStrike(computer, user);

            String result = currentSituation(ball, strike);
            System.out.println(result);

            if(isCorrect(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
    public static List<Integer> decision(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Boolean isCorrect(String result){
        if(result.equals("3스트라이크")) return true;
        else return false;
    }
    public static String currentSituation(Integer ball , Integer strike){
        if(ball == 0 && strike == 0) return "낫싱";
        else if(ball == 0) return strike + "스트라이크";
        else if(strike == 0) return ball + "볼";
        else return ball + "볼" + " " + strike + "스트라이크";
    }

    public static Integer calculationStrike(List<Integer> computer,List<Integer> user){
        Integer strike = 0;
        for(int i = 0;i<computer.size();i++){
            if(computer.get(i).equals(user.get(i)))
                strike +=1;
        }
        return strike;
    }
    public static Integer calculationBall(List<Integer> computer,List<Integer> user){
        Integer ball = 0;
        for(int i = 0;i<computer.size();i++){
            if(user.contains(computer.get(i)) && !computer.get(i).equals(user.get(i)))
                ball +=1;
        }
        return ball;
    }
    public static List<Integer> validationAndConvert(String input){
        if(input.length() != 3)  throw new IllegalArgumentException();
        Set<Integer> result = input.chars()
                .filter(c->(c >= '1' && c <= '9'))
                .map(c -> c - '0').boxed()
                .collect(toSet());
        if(result.size() != 3) throw new IllegalArgumentException();
        return input.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(toList());
    }



}
