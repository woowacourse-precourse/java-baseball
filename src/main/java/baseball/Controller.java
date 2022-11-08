package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private View view;
    private Model computer;
    private Model user;

    public void initialize() {
        this.view = new View();
        this.computer = new Model(makeRandomNumber());
        this.user = new Model();
    }

    public String makeRandomNumber() {
        String randomNumber = "";
        for (int i = 0; i < 3; i++) {
            String temp = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!randomNumber.contains("temp")) {
                randomNumber += temp;
            }
        }
        return randomNumber;
    }

    public String[] splitNumber(String number) {
        String[] numbers = number.split("");
        return numbers;
    }

    public int[] compareNumber(String computerNumber, String userNumber) {
        int ball = 0;
        int strike = 0;
        String[] numbers = splitNumber(userNumber);

        for (int i = 0; i < computerNumber.length(); i++) {
            if (computerNumber.indexOf(numbers[i]) == i) {
                strike++;
            } else if (computerNumber.contains(numbers[i])) {
                ball++;
            }
        }
        return new int[]{ball, strike};
    }

    public void runGame() {
        initialize();
        view.printLine("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("컴퓨터 숫자 : " + computer.getNumber());
            view.print("숫자를 입력해주세요 : ");
            String userNumber = view.inputNumber();
            user.setNumber(userNumber);

            int[] results = compareNumber(computer.getNumber(), user.getNumber());

            view.printResult(results[0], results[1]);

            if (terminateGame(results[1])) {
                return;
            }
        }
    }

    public boolean terminateGame(int strike) {
        String checkNumber = "";

        if (strike == 3) {
            view.printLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            view.printLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkNumber = view.inputNumber();

            if (checkNumber.equals("1")) {
                computer.setNumber(makeRandomNumber());
                return false;
            } else if (checkNumber.equals("2")) {
                return true;
            }
        }
        return false;
    }
}
