package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int findBalls(String input, List<Integer> computer)
    {
        int loc=0;
        int ball=0;
        while (loc<3){
            int valueOfCurrent = Character.getNumericValue(input.charAt(loc));
            if (computer.indexOf(valueOfCurrent) != loc && computer.contains(valueOfCurrent)){
                ball++;
//                System.out.println("I think "+valueOfCurrent+" is ball.");
            }
            loc++;
        }
        return ball;
    }
    public static int findStrikes(String input, List<Integer> computer){
        int loc=0;
        int strike=0;
        while (loc<3){
            int valueOfCurrent = Character.getNumericValue(input.charAt(loc));
            if(computer.indexOf(valueOfCurrent) == loc)
            {
                strike++;
//                System.out.println("I think "+valueOfCurrent+" is strike.");
            }
            loc++;
        }
        return strike;
    }


    public static void main(String[] args) {
        int stateOfGame = 1;
        while (stateOfGame == 1) {
            int strike = 0;
            int ball = 0;

            List<Integer> computer = getRandomList();

            while (strike != 3) {
                String inputData = Console.readLine();
                checkValid(inputData);

//        입력 값과 정답 비교
                strike = findStrikes(inputData, computer);
                ball = findBalls(inputData, computer);

                String hints = getHints(strike, ball);
                System.out.println(hints);

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            stateOfGame = Integer.parseInt(Console.readLine());
        }
    }

    private static void checkValid(String inputData) {
        if (inputData.length() != 3){
            throw new IllegalArgumentException("입력 값이 잘못되었습니다.");
        }
    }

    private static String getHints(int strike, int ball) {
        List<String> hint= new ArrayList<>();
        if(ball !=0)
        {
            hint.add(ball +"볼");
        }
        if (strike !=0)
        {
            hint.add(strike +"스트라이크");
        }
        if(hint.isEmpty())
        {
            hint.add("낫싱");
        }
        StringBuilder sb = new StringBuilder();
        for (String item : hint){
            sb.append(item);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static List<Integer> getRandomList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
