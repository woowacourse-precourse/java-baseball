package baseball;

public class Game {
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";

    private final Player computer;
    private final Player player;

    public Game() {
        this.computer = new Player();
        this.player = new Player();
    }

    public void init() {
        System.out.println(START_STRING);
    }

    public void start() {
        computer.setRandomNumber();
        player.setNumber();
        HashMap<Integer, Integer> compareBoard = new HashMap<>();
        compareBoard = getCompareBoard(computer);
        }
    private HashMap<Integer, Integer> getCompareBoard(Player computer) {
        HashMap<Integer, Integer> compareBoard = new HashMap<>();
        ArrayList<Integer> computerNumbers = computer.getNumbers();
        for (int i = 0; i < computerNumbers.size(); i++) {
            compareBoard.put(computerNumbers.get(i), i);
        }
        return compareBoard;
    }
}