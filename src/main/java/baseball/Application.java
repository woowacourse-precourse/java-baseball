package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        List<Integer> computer = game.randomPick();
        game.answer(computer);

    }
}
class Game {

    /*랜덤으로 컴퓨터가 임의의 값 선택.*/
    public List<Integer> randomPick() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /*camp.nextstep.edu.missionutils.Console 사용해서 String값 받는 함수 만들기*/
    public String campConsole() {
        return Console.readLine();
    }

    /* 게임 플레이어가 입력한 숫자 받기*/
    public List<Integer> inputNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
//        String strNumber = Console.readLine();
        String strNumber = campConsole();
        for (String chr : strNumber.split("")) {
            user.add(Integer.parseInt(chr));
        }
        return user;
    }

    /*입력된 숫자 리스트가 예외 인지 확인하는 함수*/
    public void checkException(List<Integer> user) {
        /*예외처리: 세자리가 아닐때 같은 숫자가 있을때*/
        if (user.get(0).equals(user.get(1)) || user.get(0).equals(user.get(2)) || user.get(1).equals(user.get(2))) {
            //            System.out.println("중복 숫자를 입력하지 마세요");
            //            user = inputNumber();
            throw new IllegalArgumentException();
        }
        if (!(user.size() == 3) || user.contains("-")) {
            //            System.out.println("세자리 숫자를 입력해주세요");
            //            user = inputNumber();
            throw new IllegalArgumentException();
        }
    }

    /* 컴퓨터와 입력숫자를 비교해서 스트라이크 판정 int로 반환*/
    public int strike(List<Integer> user, List<Integer> computer) {
        int countStrike = 0;
        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                countStrike++;
            }
        }
        return countStrike;
    }

    /* 컴퓨터와 입력숫자를 비교해서 볼 판정 int로 반환*/
    public int ball(List<Integer> user, List<Integer> computer) {
        int countBall = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                countBall++;
            }
            if (user.get(i).equals(computer.get(i))) {
                countBall--;
            }
        }
        return countBall;
    }

    /* 결과 두개 합쳐서 출력하는 메서드*/
    public String counting(int countStrike, int countBall) {
        if (countStrike == 0 && countBall == 0) {
            return "낫싱";
        } else if (countStrike == 3) {
            return "3스트라이크";
        } else {
            return countBall + "볼 " + countStrike + "스트라이크";
        }
    }

    /*3스트라이크일때 새로시작 및 종료 분기를 주는 메서드*/
    public String allStrike(String counting, List<Integer> computer) {

        if (counting.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            String game = Console.readLine();
            String game = campConsole();
            if (game.equals("1")) {
                List<Integer> computerNext = randomPick();

                return answer(computerNext);
            }
            return "게임종료";
        } else {
            return answer(computer);
        }
    }

    /*새로시작 메서드*/
    public String answer(List<Integer> computer) {
        List<Integer> user = inputNumber();
        checkException(user);
        int countStrike = strike(user, computer);
        int countBall = ball(user, computer);

        String counting = counting(countStrike, countBall);
        System.out.println(counting);

        allStrike(counting, computer);
        return counting;
    }
}

//class AllStrike {
//    Game gameClass = new Game();
//
//    public String allStrike(String counting, List<Integer> computer) {
//
//        if (counting.equals("3스트라이크")) {
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            String game = Console.readLine();
//            if (game.equals("1")) {
//                List<Integer> computerNext = gameClass.randomPick();
//
//                return answer(computerNext);
//            }
//            return "게임종료";
//        } else {
//            return answer(computer);
//        }
//    }
//
//    public String answer(List<Integer> computer) {
//        List<Integer> user = gameClass.inputNumber();
//        gameClass.checkException(user);
//        int countStrike = gameClass.strike(user, computer);
//        int countBall = gameClass.ball(user, computer);
//
//        String counting = gameClass.counting(countStrike, countBall);
//        System.out.println(counting);
//
//        allStrike(counting, computer);
//        return counting;
//    }
//}
