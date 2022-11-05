package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DividedRandomNumberListMakerTest {
    DividedRandomNumberListMaker listMaker = new DividedRandomNumberListMaker();

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
        List<Integer> numberList = listMaker.makeNumberList(3);

        //when
        HashSet<Integer> numberSet = new HashSet<>(numberList);

        //then
        assertThat(numberSet.size()).isEqualTo(numberList.size());
    }
}