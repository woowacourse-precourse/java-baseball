package baseball;

import java.util.List;
public class GameConsole {

    public static boolean bool = true;
    public static List<Integer> computer;

    public static Integer strikeCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;
        for (int len = 0; len < computerNumber.size(); len++) {
            if (computerNumber.get(len) == playerNumber.get(len)) {
                strike += 1;
            }
        }
        return strike;
    }

    public static Integer ballCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = 0;
        for (int len = 0; len < computerNumber.size(); len++) {
            if (!(computerNumber.get(len) == playerNumber.get(len)) && computerNumber.contains(playerNumber.get(len))) {
                ball += 1;
            }
        }
        return ball;
    }

    public static String exceptionCheck(String inputNumber) {
        if (!PlayerNumber.validCheck(inputNumber)) {
            throw new IllegalArgumentException();
        }
        return inputNumber;


    }

    public static void exitOrContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputNumber = Integer.parseInt(PlayerNumber.getString());

        if (inputNumber == 1){
            computer = ComputerNumber.arrayGetNumber();
        }else if (inputNumber == 2){
            bool = false;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    public static void gameStart() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        computer = ComputerNumber.arrayGetNumber();

        String hint = "";
        while (bool) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumber = PlayerNumber.getString();
            exceptionCheck(playerNumber);
            List<Integer> player = PlayerNumber.convertNumberList(playerNumber);

            if (ballCount(computer, player) > 0) {
                hint += ballCount(computer, player) + "볼 ";
            }

            if (strikeCount(computer, player) > 0) {
                hint += strikeCount(computer, player) + "스트라이크";
            }
            if (hint == "") {
                hint += "낫싱";
            }
            System.out.println(hint);
            hint = "";
            if (strikeCount(computer, player) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                exitOrContinue();
            }
        }
    }





}

