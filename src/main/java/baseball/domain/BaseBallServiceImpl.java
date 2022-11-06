package baseball.domain;

import baseball.config.Assembler;
import baseball.domain.entity.NumberRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseBallServiceImpl implements BaseBallService{

    private final int startRange = 1;
    private final int endRange = 9;
    private final int count = 3;

    private final NumberRepository numberRepository;

    public BaseBallServiceImpl(){
        Assembler assembler = new Assembler();
        numberRepository = assembler.numberRepository();
    }

    @Override
    public List<Integer> selectRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(startRange,endRange,count);
    }

    @Override
    public void saveRandomNumbers(List<Integer> numbers) {
        numberRepository.setNumbers(numbers);
    }

    @Override
    public void inputNumbers() {

    }

    @Override
    public void compareNumbers(List<Integer> numbers) {

    }

    @Override
    public int inputQuestionRestart() {
        return 0;
    }
}
