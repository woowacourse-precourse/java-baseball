# 구현할 기능 목록

- [x] 1부터 9까지의 값을 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms.pickNumberInRange()`를 이용해 중복 없이 3개 뽑는다.
- [x] 사용자의 입력을 비교하여 목표값(컴퓨터가 설정한 값)을 맞췄는지 계속 확인한다.
  - [x] 사용자의 입력을 `camp.nextstep.edu.missionutils.Console`의 `readLine()`으로 받는다.
    - [x] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 종료한다.
      - [x] 세자리의 값을 제대로 입력했는가
      - [x] Int형으로 변환이 가능한가
      - [x] 허용되지 않은 `0`을 사용하진 않았는가
      - [x] 각 자릿값이 중복되지 않았는가
  - [x] 받은 입력을 3자리 숫자로 변경한다.
  - [x] 입력값 3자리를 비교해 스트라이크, 볼을 판단한다.
    - [x] 자릿값과 일치 -> 스트라이크
    - [x] 해당 값이 목표값 내에 있는가 -> 볼
  - [x] 볼, 스트라이크 유무에 따라 출력
    - [x] 출력 문자를 만들어주는 메서드를 이용해 답을 맞춘 결과에 따른 문자열 생성
    - [x] 문자열이 제대로 생성되었다면 출력, 아니라면 하나도 맞추지 못 했으므로 낫싱 출력

- [x] 게임을 새로 시작하거나 종료한다.
  - [x] 1 or 2의 값 입력에 따라 새 게임 시작, 종료를 구분. 만약 잘못된 값을 입력했을 경우 반복하여 물어봄

# 고려한 점

-  `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`를 이용하여 1부터 9까지의 값을 3개 뽑아야 한다.
  - ~~`Randoms` 내에 `pickUniqueNumbersInRange`라는 메서드가 있다는 것을 발견하였다. 이름만 봐도 중복 없이 값을 뽑는다는 듯 했다.~~
  - ~~매개변수는 `startInclusive`, `endInclusive`, `count`가 있었다. 시작값, 끝값, 뽑을 횟수를  뜻했다.~~
  - ~~내부 코드를 확인해보니, `validateRange`로 범위 값 제한이 올바른지, `validateCount`로 count의 선언이 올바른지를 검사하고 있었다.~~
    - ~~`validateRange`는 시작값 <= 끝값 관계 및 int형에서의 최댓값을 넘어가거나 최댓값 이상의 갯수를 지니는지 확인한다.~~
    - ~~`validateCount`는 뽑을 횟수값이 음수거나 지정한 범위보다 많은지를 확인한다.~~
  - ~~입력이 올바르게 들어왔다면, 해당하는 List를 만든 뒤 시작값부터 끝값을 추가, 랜덤으로 섞은 후 앞에서부터 뽑을 횟수만큼 잘라 반환하는 형태였다.~~
  - ~~로직의 흐름을 충분히 따라갈 수 있었기에, 해당 메서드를 사용하기로 했다.~~
  - `Randoms.pickNumberInRange()`만을 활용하여 구성하여야 했다. 프로그래밍 요구 사항에 있었으나, 깜빡 지나쳐버렸었다. **요구 사항을 잘 읽자..**
- 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 종료하여야 한다.
  - 세자리인지 먼저 확인하고 변환하는게, 추후 length 관련 에러를 막을 수 있다고 판단하였다.
  - 세자리는 맞으나 공백 등 정수형으로 변경할 수 없는 경우에도 물론 띄워줘야 한다.
  - 1부터 9까지만 사용해야 하며, 값의 중복은 set으로 판단할 수 있었다.
  - 해당 구조는 `Randoms.pickUniqueNumbersInRange`의 `validateRange`, `validateCount`를 참고하였다.
- 게임의 새 시작과 종료를 구분짓는 메서드에서는 잘못된 값을 입력할 경우 재차 물어본다.
  - `종료 == 2` 라는 결정권이 주어졌을 때, `잘못된 값 입력시 종료`를 수행하게 되면 이는 곧 `1 이외 값 입력시 종료` 조건으로 변질될 수 있기 때문

# 고민한 사항

- 받은 입력값을 3자리로 변환할 수 있는지를 확인하고, 가능하다면 변환하여 검사해야 한다. 이 때, 변환하여 검사 후 이상이 없다면 반환하게끔 구성한다면.. 메서드 이름을 어떻게 지어야 할 것인가?
  - 기존 코드 작성 방향은 `값 입력` -> `제대로 된 입력인지 확인` -> `제대로 된 입력이라면 변환하여 사용` 순으로 하려 했으나, `값 입력` -> `제대로 된 입력인지 직접 변환하여 테스트, 이상 없다면 반환`으로 변경하는 게 좋을 것 같다는 생각이 들었다.
  - 그러나, 이런 구조라면 메서드명을 어떻게 지어야 할 지 난감했다. 확인받은 후 이상이 없다면 값을 반환받는 것이니, `ifValueIsAcceptable`로 하려 했는데 다른 사용자가 보고 납득할 수 있는지 감이 잘 오지 않았다. 값을 반환받는 느낌보다 확인한다는 느낌이 더 강하게 들었다.. 우선은 값을 가져온다고 표현해주는 게 먼저일 것 같아 `getValueIfAcceptable`로 적었는데, 이것도 약간 마음에 들진 않는다. 더 좋은 메서드명을 위해 고민해봐야 할 것 같다.

# 트러블 슈팅

## 경고 출력문

```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by camp.nextstep.edu.missionutils.Console (file:/C:/Users/eora2/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.0.0/dad5230ec970560465a42a1cade24166e6a424f4/mission-utils-1.0.0.jar) to field java.util.Scanner.sourceClosed
WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```

반복문을 통해 입력을 받다가 해당 경고가 출력되었다.

구글링을 해 보니, JDK 버전과 타 라이브러리 버전이 맞지 않아 생긴 문제라고 한다.

하지만 프리코스에서는 JDK 11버전을 사용하며, `build.gradle` 파일을 변경할 수 없고, 무엇보다 **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리**를 하기에.. `일부러 이런 에러가 뜨게끔 구성한건가? 아니면 내 코드 문제일까?`에 대해 고민했다. 단순 경고창을 띄우는 거라곤 하지만.. 그래도 불안한 건 어쩔 수 없는 것 같다.

## 테스트 코드

```java
@Test
void 게임종료_후_재시작() {
    assertRandomNumberInRangeTest(
        () -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        },
        1, 3, 5, 5, 8, 9
    );
}
```

해당 구문을 보면, 답을 `135`와 `589`를 강제해놓고 코드를 돌리는 듯 했다.

헌데 `assertRandomNumberInRangeTest`의 매개변수는 `final Executable executable`, `final Integer value`, `final Integer... values`였고, 따라서 `value`에는 `1`이, `values`에는 `3, 5, 5, 8, 9`가 들어가는 형태였다.

이게 어떤 의미로 이렇게 들어간 건지, 저렇게 넣으면 값이 고정되는지 코드를 출력해봤으나, 내 코드 기준에서는 목표값으로 빈 리스트만 출력되고 있었다.

내 짧은 견해로는, `mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());` 코드에서 랜덤 값을 `1, 3, 5, 5, 8, 9` 순으로 고정시키는 것 같은데, 왜 내 코드에서는 작성되지 않는지 의문이다. `pickUniqueNumbersInRange()`를 사용해서 그런 걸까?

혹시나 하는 마음에 `pickNumberInRange()`를 사용하여 코드를 돌려보았는데.. 정답이 떴다.. `프로그래밍 요구 사항` 중 `라이브러리` 항목에 `pickNumberInRange()`를 활용하라고 떡하니 적혀 있었는데, 이를 놓치고 헛고생을 하고 있었다..

반성할 시간을 가졌다. 그래도 그 과정에서 배운 것은, 역시 메서드를 쪼개 놓으니 딱 원하는 부분만 수정하여 결과를 얻어낼 수 있었다는 점이다.

또, `pickUniqueNumbersInRange()`에서는 왜 안돌아간 건지 궁금해져서 찾아보기로 했다.

### `pickUniqueNumbersInRange()`에서는 왜 안돌았을까

공부해보고 추가할 것.

# 느낀 점

- 코드를 작성하는 시간보다 README의 `구현할 기능 목록`을 고민하고 수정하는 시간이 더 많은 것 같다. 코드를 타이핑하다 보면 빼먹거나 순서를 잘못 생각한 기능들을 파악하게 되고, 해당하는 사항들을 정리하며 머릿속으로 로직을 다시 생각하는 과정이 반복된다. 실력이 증가하는 과정이겠지만, 그동안 정말 대책없이 코드를 작성했구나 하며 반성하게 된다. 