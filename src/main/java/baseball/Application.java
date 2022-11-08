package baseball;

public class Application {

    public static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> playerNumber(String input) {
        List<Integer> player = new ArrayList<>();
        int num;
        for (char c : input.toCharArray()) {
            num = Character.getNumericValue(c);
            if (player.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 04 : 중복되는 숫자가 입력되었습니다.");
            }
            player.add(num);
        }
        return player;
    }

    public static void playerNumException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 01 : 아무것도 입력하지 않았습니다.");
        } else if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 02 : 숫자 이외의 문자가 포함되어 있습니다.");
        } else if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 03 : 숫자가 3자리가 아닙니다.");
        }
    }

    public static boolean evaluate(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        return (strike == 3);
    }

    public static void printResult(int strike, int ball) {
        if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static void exitSequenceException(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 05 : 잘못된 값이 입력되었습니다.");
        }
    }


    public static void main(String[] args) {
        String input;
        List<Integer> computer;
        List<Integer> player;
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            computer = randomNumber();
            do {
                System.out.print("숫자를 입력해주세요 : ");
                input = Console.readLine();
                playerNumException(input);
                player = playerNumber(input);
            } while (!evaluate(computer, player));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
            input = Console.readLine();
            exitSequenceException(input);
        } while (!input.equals("2"));
    }
}
