package baseball.domain;

import baseball.config.Assembler;
import baseball.domain.repository.NumberRepository;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseBallServiceImpl implements BaseBallService{

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

        int count1 = 3;
        while(count < count1){
            int startRange = 1;
            int endRange = 9;
            int randomNumber = Randoms.pickNumberInRange(startRange, endRange);

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
        String input = Console.readLine();
        verification.onlyNumberVerification(input);
        return input;
    }
    @Override
    public void verify(String input) {
        verification.lengthVerification(input);
        verification.rangeVerification(input);
        verification.uniqueNumberVerification(input);
    }

    @Override
    public List<Integer> stringToIntegerList(String input) {

        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public GameResult compareNumbers(List<Integer> userSelectNumbers) {
        List<Integer> selectedNumbers = getSelectedNumbers();

        GameResult gameResult = new GameResult();
        searchingNumbers(selectedNumbers,0,0,userSelectNumbers,0,gameResult);

        return gameResult;
    }
    private void searchingNumbers(List<Integer> selectedNumbers,int selectedNumbersIdx,int userSelectNumbersIdx,List<Integer> userSelectNumbers,int depth,GameResult gameResult){

        if(depth == 3)
            return;

        if (userSelectNumbersIdx == 3) {
            searchingNumbers(selectedNumbers, selectedNumbersIdx + 1, 0, userSelectNumbers, depth + 1, gameResult);
            return;
        }

        if(Objects.equals(selectedNumbers.get(selectedNumbersIdx), userSelectNumbers.get(userSelectNumbersIdx))){
            if(selectedNumbersIdx == userSelectNumbersIdx){
                gameResult.increaseStrikeCount();
            }
            else {
                gameResult.increaseBallCount();
            }

            searchingNumbers(selectedNumbers,selectedNumbersIdx+1,0,userSelectNumbers,depth+1,gameResult);
            return;
        }

        searchingNumbers(selectedNumbers,selectedNumbersIdx,userSelectNumbersIdx+1,userSelectNumbers,depth,gameResult);
    }
    private List<Integer> getSelectedNumbers(){

        return numberRepository.getNumbers();
    }

    @Override
    public int inputQuestionRestart() {
        return 0;
    }

}
