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


    public static void main(String[] args) {
        String input;
        List<Integer> computer;

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = randomNumber();
        System.out.print("숫자를 입력해주세요 : ");

    }
}
