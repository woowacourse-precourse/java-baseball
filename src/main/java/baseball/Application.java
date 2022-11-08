package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        print("숫자 야구 게임을 시작합니다.\n");
        
        boolean isOver = false;
        
        while (!isOver) {
            isOver = startNewGame();
        }
        
    }
    
    static boolean startNewGame() {
        Integer userAnswerNumber = null;
        userAnswerNumber = getIntegerInput();
        print("\n");
        
        boolean isOver;
        
        if (userAnswerNumber == 1) {
            isOver = false;
        } else if (userAnswerNumber == 2) {
            isOver = true;
        } else {
            throw new IllegalArgumentException();
        }
        
        return isOver;
    }
    
    static void print(String text) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException error) {
            error.printStackTrace();
        }
        
    }
    
    static Integer getNewAnswer() {
        List<Integer> numbers = new ArrayList<>();
        
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
            
        }
        
        int result = 0;
        
        for (int index = numbers.size() - 1, digit = 1; 0 <= index; index--) {
            result += numbers.get(index) * digit;
            digit *= 10;
        }
        
        return result;
    }
    
    static Integer getIntegerInput() throws IllegalArgumentException {
        
        try {
            String userInput = Console.readLine();
            Integer result = Integer.parseInt(userInput);
            return result;
        } catch(NumberFormatException error) {
            throw new IllegalArgumentException();
        }
        
    }
}