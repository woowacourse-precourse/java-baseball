package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean newGame = true;

        while(newGame){
            List<Integer> computer = makeComputer();
            List<Integer> user = inputNumber();
            checkAnswer(computer, user);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String command = Console.readLine();
            newGame = restartGame(command);
        }
    }

    public static List<Integer> makeComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputNumber(){
        List<Integer> li = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();

        isCorrectType("^[1-9]{3}$", str);
        isDuplication(str);

        for(int i = 0; i < 3; i++){
            int tmp = str.charAt(i) - '0';
            li.add(tmp);
        }
        return li;
    }

    public static void isCorrectType(String pattern, String str){
        boolean result = Pattern.matches(pattern, str);

        if(!result){
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplication(String str) {
        Set<Character> hs = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (hs.contains(c)) {
                throw new IllegalArgumentException();
            }
            hs.add(c);
        }
    }
    public static void checkAnswer(List<Integer> computer, List<Integer> user){
        int ball = 0;
        int strike = 0;

        for(int i = 0; i<user.size(); i++){
            int num = user.get(i);

            if(computer.indexOf(num) == i){
                strike++;
                continue;
            }
            if(computer.contains(num)){
                ball++;
            }
        }
        printResult(ball, strike);

        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        user = inputNumber();
        checkAnswer(computer, user);
    }
    public static void printResult(int ball, int strike){
        StringBuilder sb = new StringBuilder();

        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
            return;
        }
        if(ball > 0){
            sb.append(ball + "볼");
        }
        if(ball * strike > 0){
            sb.append(" ");
        }
        if(strike > 0){
            sb.append(strike + "스트라이크");
        }
        System.out.println(sb.toString());
    }
    public static boolean restartGame(String command){
        isCorrectType("^[1-2]$", command);

        if(Objects.equals(command, "1")){
            return true;
        }
        return false;
    }
}
