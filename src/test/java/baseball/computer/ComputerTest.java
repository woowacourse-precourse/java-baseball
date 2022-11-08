package baseball.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    @DisplayName("check opponent makes 3 digit integer properly")
    public void initialize_computer_Test() {
        Computer computer = new Computer();
        computer.createRandomNumbers();
        assertThat(computer.getDigits()).doesNotHaveDuplicates();
    }
    @Test
    public void get_Index_From_Integer_List_Test(){
        Computer computer = new Computer();
        List<Integer> computerNumbers;
        int firstElement;
        int firstIndex=0;
        int returnIndex;
        computer.createRandomNumbers();
        computerNumbers=computer.getDigits();
        firstElement=computerNumbers.get(firstIndex);
        returnIndex=computerNumbers.indexOf(firstElement);

        assertThat(returnIndex).isEqualTo(firstIndex);
    }
    @Test
    public void get_Index_From_Integer_List_Not_Exist_Element_Test(){
        Computer computer = new Computer();
        List<Integer> computerNumbers;
        int notExistsElement=0;
        int notExistsElementIndex=-1;
        int returnIndex;
        computer.createRandomNumbers();
        computerNumbers=computer.getDigits();
        returnIndex=computerNumbers.indexOf(notExistsElement);

        assertThat(returnIndex).isEqualTo(notExistsElementIndex);
    }
}
