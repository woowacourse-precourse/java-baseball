package baseball.dto;

import baseball.dao.ComputerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Number 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class NumberTest {
    @Test
    void 데이터_삽입_삭제_조회() {
        Number dto = Number.getInstance();

        assertThat(dto.insert(new ComputerNumber(123))).isTrue();

        ComputerNumber dao = dto.latest();

        assertThat(dao.getNumber()).isEqualTo(123);
        assertThat(dto.getAll().size()).isEqualTo(1);
        assertThat(dto.delete(dao)).isTrue();
    }
}
