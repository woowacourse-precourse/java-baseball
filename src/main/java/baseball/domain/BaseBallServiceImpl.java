package baseball.domain;

import baseball.config.Assembler;
import baseball.domain.repository.NumberRepository;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBallServiceImpl implements BaseBallService{

    private final int startRange = 1;
    private final int endRange = 9;
    private final int count = 3;

    private final NumberRepository numberRepository;
    private final Verification verification;

    public BaseBallServiceImpl(){
        Assembler assembler = new Assembler();
        numberRepository = assembler.numberRepository();
        this.verification = assembler.verification();
    }

    @Override
    public List<Integer> selectRandomNumbers() {

        int count = 0;
        List<Integer> uniqueNumbers = new ArrayList<>();

        while(count < this.count){
            int randomNumber = Randoms.pickNumberInRange(startRange,endRange);

            if(!uniqueNumbers.contains(randomNumber)){
                uniqueNumbers.add(randomNumber);
                count +=1;
            }
        }
        return uniqueNumbers;
    }

    @Override
    public void saveRandomNumbers(List<Integer> numbers) {
        numberRepository.setNumbers(numbers);
    }
    @Override
    public String inputString() {
        return Console.readLine();
    }
    @Override
    public void verify(String input) {
        verification.lengthVerification(input);
        verification.onlyNumberVerification(input);
        verification.rangeVerification(input);
        verification.uniqueNumberVerification(input);
    }

    @Override
    public List<Integer> stringToIntegerList(String input) {

        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public void compareNumbers(List<Integer> numbers) {

    }

    @Override
    public int inputQuestionRestart() {
        return 0;
    }
}
