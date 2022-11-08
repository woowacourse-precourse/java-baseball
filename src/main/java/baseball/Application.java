package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현s

        while(true)
        {
            playBaseBall();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요.");
            int exit = Integer.parseInt(Console.readLine());
            if(exit == 2)
                break;
        }
    }

    //야구 게임이 시작되는 메서드
    private static void playBaseBall()
    {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String randomNum = getRandomNum();

        startGame(randomNum);
    }

    //컴퓨터에서 선택한 랜덤 숫자
    private static String getRandomNum()
    {
        String randomNum = "";
        String addNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
        while(true)
        {
            if(randomNum.contains(addNum))
                addNum = String.valueOf(Randoms.pickNumberInRange(1, 9));
            else
                randomNum += addNum;

            if(randomNum.length() == 3)
                break;
        }
        return randomNum;
    }

    //게임이 시작되며, 계산 후 결과를 출력해주는 메서드
    private static void startGame(String randomNum)
    {
        while (true)
        {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();
            checkNum(inputNum);

            String result = getResult(randomNum, inputNum);
            System.out.println(result);
            if(result.equals("3스트라이크"))
            {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    //입력한 숫자를 체크하는 메서드
    public static void checkNum(String inputNum)
    {
        String regex = "[1-9]{3}";
        if(!inputNum.matches(regex))
            throw new IllegalArgumentException("Invalid Num");

        char[] inputNumArray = inputNum.toCharArray();
        int k = 0;
        for(int i = 0; i < inputNumArray.length; i++)
        {
            int comparenum1 = inputNumArray[k];
            int comparenum2 = 0;
            if(k == 2)
                comparenum2 = inputNumArray[0];
            else
                comparenum2 = inputNumArray[k+1];

            if(comparenum1 == comparenum2)
                throw new IllegalArgumentException("Invalid Num");

            k++;
        }
    }

    //찾아낸 결과를 사용자화로 변환
    private static String getResult(String randomNum, String inputNum)
    {
        int[] match = compareNum(randomNum, inputNum);
        if(match[0] == 0 && match[1] == 0)
            return "낫싱";

        String result = "";
        if(match[0] != 0)
            result += match[0] + "볼 ";
        if(match[1] != 0)
            result += match[1] + "스트라이크";

        return result.trim();
    }

    //randomNum과 inputNum을 비교하여 결과를 찾아내는 메서드
    private static int[] compareNum(String randomNum, String inputNum)
    {
        int[] match = {0, 0};

        char[] randomNumArray = randomNum.toCharArray();

        for(int i = 0; i < randomNum.length(); i++)
        {
            if(inputNum.contains(String.valueOf(randomNumArray[i])))
                match = calResult(match, matchNum(inputNum, randomNumArray[i], i));
        }

        return match;
    }

    //ball인지 strike인지 구별하는 메서드
    private static char matchNum(String inputNum, char numchar, int index)
    {
        boolean isStrike = false;
        char[] inputNumArray = inputNum.toCharArray();
        for(int i = 0; i < inputNumArray.length; i++)
        {
            if(i == index && numchar == inputNumArray[i])
                isStrike = true;
        }

        if(isStrike)
            return 's';
        else
            return 'b';
    }

    //매치되는 ball과 strike를 계산하는 메서드
    private static int[] calResult(int[] match, char matchChar)
    {
        if(matchChar == 'b')
            match[0] += 1;
        else if(matchChar == 's')
            match[1] += 1;

        return match;
    }
}