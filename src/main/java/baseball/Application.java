package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            List<Integer> computernums = RandomNum(3);
            gameStart(computernums);
            System.out.print("1이나 2를 입력해주세요.");
            String userfinalinput = userInput();
            confirmUserFinalInput(userfinalinput);
            if (userfinalinput.equals("2")) {
                break;
            }
        } while (true);

    }

    public static void gameStart(List<Integer> computernums) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            UserNums usernum = new UserNums(Console.readLine());
            BaseballCount baseballCount = new BaseballCount(computernums, usernum.getNumbers());
            if (allStrike(baseballCount)) {
                allStrikeMessage();
                break;
            }
            if (allNotSame(baseballCount)) {
                allNotSameMessage();
                continue;
            }
            baseballCountMessage(baseballCount);
        }
    }

    public static boolean allStrike(BaseballCount baseballCount) {
        return baseballCount.strikecount == 3;
    }

    public static void allStrikeMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean allNotSame(BaseballCount baseballCount) {
        return baseballCount.strikecount == 0 && baseballCount.ballcount == 0;
    }

    public static void allNotSameMessage() {
        System.out.println("낫싱");
    }

    public static void baseballCountMessage(BaseballCount baseballCount) {
        System.out.printf("%d볼 %d스트라이크", baseballCount.ballcount, baseballCount.strikecount);
    }


    public static void confirmUserFinalInput(String userfinalinput) {
        if (!userfinalinput.equals("1") && !userfinalinput.equals("2")) {
            throw new IllegalArgumentException("1이나 2가 아닙니다.");
        }
    }

    public static String userInput() {
        String usernum = Console.readLine();
        return usernum;
    }


    public static List<Integer> RandomNum(int count) {
        List<Integer> list = new ArrayList<>();
        while (list.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return list;
    }
}
