package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DividedRandomNumberElementListMakerTest {
    DividedRandomNumberElementListMaker listMaker = new DividedRandomNumberElementListMaker();

    @Test
    public void isNumberStrangerOnNumberList_메서드로_숫자가_numberList에_존재하는지_구분() throws Exception {
        //given
        List<Integer> numberList = List.of(1, 2);
        int numberToAdd = 1;

        //when
        boolean isStranger = listMaker.isNumberStrangerOnNumberList(numberToAdd, numberList);

        //then
        assertThat(isStranger).isEqualTo(false);
    }

    @Test
    public void makeNumberList로_만들어진_리스트에_중복된_숫자가_있는지_확인() throws Exception {
        //given
        List<Integer> numberList = listMaker.makeElementList(3);

        //when
        HashSet<Integer> numberSet = new HashSet<>(numberList);

        //then
        assertThat(numberSet.size()).isEqualTo(numberList.size());
    }

    @Test
    public void convertToElementList_메서드로_String타입의_숫자를_각_자리별_숫자리스트로_변환() throws Exception {
        //given
        String stringNumber = "123";

        //when
        List<Integer> elementList = listMaker.convertToElementList(stringNumber);

        //then
        assertThat(elementList).isEqualTo(List.of(1, 2, 3));
    }
}