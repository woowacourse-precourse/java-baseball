package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {

        while (true)
        {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> randomNumber = getRandomNumber();

            boolean isThreeStrike = false;

            while (!isThreeStrike)
            {
                System.out.print("숫자를 입력해주세요 : ");

                List<Integer> inputNumber = makeUserNumber();
                List<Integer> results = playGame(randomNumber, inputNumber);
                isThreeStrike = checkGameResult(results);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String select = Console.readLine();

            if(select.equals("2"))
            {
                break;
            }
        }

    }


    private static List<Integer> getRandomNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }


    private static List<Integer> makeUserNumber(){

        List<Integer> inputNumber = new ArrayList<>();
        String consoleInputNumber = Console.readLine();

        if(consoleInputNumber.length() != 3)
        {
            throw new IllegalArgumentException("3자리의 숫자를 입력해야합니다.");
        }

        for(int i =0 ; i < consoleInputNumber.length(); i++)
        {
            Integer number = Integer.parseInt(String.valueOf(consoleInputNumber.charAt(i)));
            // 같은 숫자를 입력한 예외 케이스 체크
            if(inputNumber.contains(number))
            {
                throw new IllegalArgumentException("같은 숫자를 입력했습니다.");
            }

            inputNumber.add(number);
        }

        return inputNumber;

    }


    private static List<Integer> playGame(List<Integer> computerNumber, List<Integer> userNumber) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumber.size(); i++)
        {
            // 만약 유저가 입력한 숫자와 컴퓨터 임의의 숫자가 같다면 strike를 하나 추가
            if(userNumber.get(i).equals(computerNumber.get(i)))
            {
                strike+=1;
            }
            // 만약 유저가 입력한 숫자가 컴퓨터의 임의의 숫자에 포함된다면 ball을 하나 추가
            else if(computerNumber.contains(userNumber.get(i)))
            {
                ball+=1;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(strike);
        result.add(ball);

        return result;
    }


    private static void gameOutput(List<Integer> results)
    {
        int strike = 0;
        int ball = 0;

        strike = results.get(0);
        ball = results.get(1);

        if ( ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        else if ( ball == 0 ){
            System.out.println(strike+"스트라이크");
        }
        else if ( strike == 0 ){
            System.out.println(ball+"볼");
        }
        else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }


    private static boolean checkGameResult(List<Integer> results) {

        if(results.get(0) == 3)
        {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        else {
            gameOutput(results);
            return true;
        }
    }
}
