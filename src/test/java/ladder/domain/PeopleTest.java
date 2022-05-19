package ladder.domain;

import ladder.exception.InvalidCountOfPersonException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PeopleTest {

    @Test
    @DisplayName("참가자 수는 2 이상이여야 한다.")
    void invalidCount() {
        assertThatThrownBy(() -> new People("tom"))
                .isInstanceOf(InvalidCountOfPersonException.class)
                .hasMessage("참가자의 수는 2 이상이여야 합니다.");
    }

    @Test
    @DisplayName("총 필요한 좌표 개수는 사람의 수보다 1 작다.")
    void totalPoint() {
        assertThat(new People("tom", "tommy", "paul").pointCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("이름 문자열을 입력하면 구분자로 나누어 People 를 생성한다.")
    void create() {
        assertThat(new People("tom,tommy")).isEqualTo(new People("tom", "tommy"));
        assertThat(new People("tom,tommy")).isEqualTo(new People(List.of(new Person("tom"), new Person("tommy"))));
    }
}