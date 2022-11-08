# 기능 목록 구현

### `printStart` 함수 
* 게임 시작 알림
* `숫자 야구 게임을 시작합니다.` 출력

### `makeAnswer` 함수
* 중복되지 않는 랜덤한 수 3개 나열
* 입력: -
* 출력: `List<Integer>`

### `takeGuess` 함수
* `숫자를 입력해 주세요 :` 출력
* 사용자의 답 입력 받기
* 입력: -
* 출력: `String`

### `checkGuess` 함수
* 사용자가 답을 올바른 형식으로 작성했는지 확인
* 숫자인지 확인 (`isNumeric` 함수)
* 길이가 3인지 확인
* 중복값이 존재하는지 확인 (`isRepeated` 함수)
* 입력: `String`
* 출력: `IllegalArgumentException` 

### `splitGuess` 함수
* 문자열 형태인 사용자의 답을 정수 리스트로 쪼갬
* 입력: `String`
* 출력: `List<Integer>`

### `takeChoice` 함수
* 새 게임 시작 여부에 대한 사용자의 선택지 입력 받기
* 입력: -
* 출력: `String`

### `checkChoice` 함수
* 사용자가 선택지를 올바른 형식으로 작성했는지 확인
* `"1"` 또는 `"2"`인지 확인
* 입력: `String`
* 출력: `IllegalArgumentException`

### `compareDigit` 함수
* 사용자 답의 한 문자와 정답 비교
* 입력: `String`, `String`, `int`
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  정답, 사용자 답 n번째 문자, n(인덱스)
* 출력: `String`
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  숫자 하나에 해당하는 힌트 (ball / strike / nothing)

### `hintPerDigit` 함수
* 한 숫자씩 정답과 비교하여 결과를 리스트에 저장
* `compareDigit` 3번 실행
* 입력: `List<Integer>`, `List<Integer>`
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  정답, 사용자 답
* 출력: `List<String>`
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  각 인덱스에 해당하는 힌트

### `finalHint` 함수
* 리스트에 있는 볼, 스트라이크, 낫싱 개수 세기
* 개수로 최종 힌트에 대한 문자열 조합
* 입력: `List<Integer>`, `List<Integer>`
  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  정답, 사용자 답
* 추력: `String`