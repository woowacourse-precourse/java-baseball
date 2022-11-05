package baseball;

import baseball.Input.InputManageable;
import baseball.Output.OutputManageable;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class GameController {
    private static final Integer INPUT_SIZE = 3;
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 9;
    private static final String VALID_INPUT_PATTERN = "^[1-9]*$";
    private List<Integer> randomNumber;

    public GameController()
    {
        randomNumber = new ArrayList<>();
    }

    public void generateRandomNumber()
    {
        if(!randomNumber.isEmpty())
        {
            randomNumber.removeAll(randomNumber);
        }

        while(randomNumber.size() != 3)
        {
            int randInt = Randoms.pickNumberInRange(START_INCLUSIVE,END_INCLUSIVE);
            if(!randomNumber.contains(randInt)) randomNumber.add(randInt);
        }

        System.out.println("getRandomNumber() = " + getRandomNumber());
    }

    public Integer getRandomNumber()
    {
        if(randomNumber.isEmpty()) generateRandomNumber();
        return randomNumber.get(0)*100 + randomNumber.get(1)*10 + randomNumber.get(2);
    }

    private boolean hasDuplication(String userInput)
    {
        Set<Character> inputCharacterSet = new HashSet<>();

        for(int index = 0; index < userInput.length();index++)
        {
            char userInputCharacterAtIndex = userInput.charAt(index);

            if(inputCharacterSet.contains(userInputCharacterAtIndex))
            {
                return true;
            }

            inputCharacterSet.add(userInputCharacterAtIndex);
        }

        return false;
    }

    private boolean hasInvalidCharacter(String userInput)
    {
        return !Pattern.matches(VALID_INPUT_PATTERN,userInput);
    }
    public boolean isValidUserInput(String userInput)
    {
        if (userInput.length() != INPUT_SIZE || hasInvalidCharacter(userInput) || hasDuplication(userInput))
        {
            return false;
        }

        return true;
    }

    public String getHint(String userInput)
    {
        if(!isValidUserInput(userInput))
            throw new IllegalArgumentException("잘못된 숫자를 입력하였습니다. 프로그램을 종료합니다.");

        int userInputNumber = Integer.parseInt(userInput);
        return HintGenerator.generateHint(userInputNumber,randomNumber);
    }

    public boolean isAnswer(String userInput)
    {
        return getRandomNumber() == Integer.parseInt(userInput);
    }




}
