package baseball.application.context;

import baseball.application.config.BaseBallGameConfig;
import baseball.application.io.Reader;
import baseball.application.io.Writer;
import baseball.application.random.RandomNumberGenerator;
import baseball.application.random.Range;
import baseball.domain.comparator.Comparator;
import baseball.domain.computer.Computer;
import baseball.domain.number.BaseBallGameNumbers;
import baseball.domain.player.Player;
import baseball.domain.result.CompareResult;
import baseball.domain.step.GameStartStep;
import baseball.domain.step.Step;

import java.util.List;

public class BaseBallGameContext {

    /* 켬퓨터가 가질 수 있는 수의 범위 */
    private static final Range RANGE = new Range(1, 9);

    /* 컴퓨터가 가질 수 있는 수의 개수 */
    private static final int COUNT = 3;

    private final Writer writer;
    private final Reader reader;
    private final RandomNumberGenerator randomNumberGenerator;

    private Player player;
    private Computer computer;

    /* 현재 진행중인 게임의 단계 */
    private Step step;

    private final Comparator comparator = new Comparator();

    public BaseBallGameContext(BaseBallGameConfig config) {
        this.writer = config.writer();
        this.reader = config.reader();
        this.randomNumberGenerator = config.randomNumberGenerator();

        // 게임 시작 스텝으로 설정
        this.step = new GameStartStep();
    }

    public void init() {
        this.player = new Player();

        List<Integer> numbers = randomNumberGenerator.generateUniqueNumberInRange(RANGE, COUNT);
        BaseBallGameNumbers result = new BaseBallGameNumbers(numbers);
        this.computer = new Computer(result);
    }

    public void changePlayerNumbers(BaseBallGameNumbers baseBallGameNumbers) {
        player.changeNumbers(baseBallGameNumbers);
    }

    public void println(String message) {
        writer.println(message);
    }

    public void print(String message) {
        writer.print(message);
    }

    public String readLine() {
        return reader.readLine();
    }

    public CompareResult comparePlayerAndComputer() {
        return comparator.compare(
                player.baseBallGameNumbers(),
                computer.baseBallGameNumbers());
    }

    public boolean executable() {
        return step.executable();
    }

    public void execute() {
        // 현재 단계 실행
        step.execute(this);

        // 실행 후 다음 단계로 넘어감
        step = step.next();
    }
}
