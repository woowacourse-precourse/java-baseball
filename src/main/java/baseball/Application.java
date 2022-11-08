package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
    }
    
    private static void print(String text) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException error) {
            error.printStackTrace();
        }
        
    }
    
    private static Integer getNewAnswer() {
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
}