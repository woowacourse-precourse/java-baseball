package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private View view;

    private Model computer;
    private Model user;

    public Controller(Model computer, Model user) {
        this.computer = computer;
        this.user = user;
    }

    public void setNumber(Model model, String number) {
        model.setNumber(number);
    }

    public String getNumber(Model model) {
        return model.getNumber();
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
        String randomNumber = String.valueOf(Randoms.pickNumberInRange(111, 999));
        computer = new Model(randomNumber);

        view.printLine("숫자 야구 게임을 시작합니다.");
        while (true) {
            view.print("숫자를 입력해주세요 : ");
            String userNumber = view.inputInt();
            user = new Model(userNumber);

            int[] results = compareNumber(computer.getNumber(), user.getNumber());

            view.printResult(results[0], results[1]);

            if (results[1] == 3) {
                view.printLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                view.printLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String checkNumber = view.inputInt();
                if (checkNumber.equals("1")) {
                    continue;
                } else if (checkNumber.equals("2")) {
                    break;
                }
            }
        }
    }
}
