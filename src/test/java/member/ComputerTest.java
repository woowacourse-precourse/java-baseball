package member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 컴퓨터가_세자리_수가_설정되는지_확인() {
        //given
        Computer computer = new Computer();
        //when
        computer.setNumbers();
        //then
        assertThat(computer.getNumbers().size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터의_각_자리_수가_다른지_확인() {
        //given
        Computer computer = new Computer();
        //when
        computer.setNumbers();
        //then
        assertThat(computer.getNumbers().stream().distinct().count()).isEqualTo(3);
    }

    @Test
    void 컴퓨터가_1부터_9까지의_숫자만을_가지는지_확인() {
        //given
        Computer computer = new Computer();
        String regex = "[1-9]{1,3}";
        //when
        computer.setNumbers();
        //then
        List<String> computerStringNumbers = computer.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        
        String computerNumber = String.join("", computerStringNumbers);

        assertThat(Pattern.matches(regex, computerNumber)).isTrue();
    }
    
    @Test
    public void 컴퓨터의_수가_초기화되는지_확인 () {
        //given
        Computer computer = new Computer();
        //when
        computer.setNumbers();
        computer.clearNumbers();
        //then
        assertThat(computer.getNumbers()).isEqualTo(Collections.emptyList());
    }
}