package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 컴퓨터의 숫자 생성
    public static List<Integer> computer() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 플레이어의 숫자 입력
    public static List<Integer> playerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        int[] playerNumArr = new int[3];

        System.out.print("숫자를 입력해주세요 : ");
        String numberStr = Console.readLine();

        // 3개의 숫자가 아닐 때
        if(numberStr.length() != 3) {
            throw new IllegalArgumentException("Not Three Number");
        }

        for(int i = 0; i < 3; i++) {
            playerNumArr[i] = Integer.parseInt(numberStr.substring(i, i + 1));

            // 1에서 9까지가 아닐 때
            if(!(playerNumArr[i] >= 1 && playerNumArr[i] <= 9)) {
                throw new IllegalArgumentException("Wrong Number");
            }

            // 서로 다른 임의의 수가 아닐 때
            if(i != 0 && (playerNumArr[i] == playerNumArr[i - 1])) {
                throw new IllegalArgumentException("Same Number");
            }

            playerNumber.add(playerNumArr[i]);
        }

        return playerNumber;
    }
}
