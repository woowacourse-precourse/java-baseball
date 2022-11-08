# 📖 기능 목록

## 숫자야구게임의 진행

  - 컴퓨터의 랜덤한 값(정답)을 생성한다.
  - 점수를 구한다.
  - 결과를 반환한다.
    - 볼, 스트라이크, 낫싱
  - 프로그램 종료조건을 검증한다.
    - 재시작
    - 종료

## 숫자야구 게임 진행간 필요한 값
  - 값
    - `STRIKE("스트라이크")`
    - `BALL("볼")`
    - `NOTHING("낫싱")`
  - 숫자를 넣었을 때 결과 문구로 반환해주는 기능
    - `of(int number)`
      - ex) BALL.of(1) return `"1볼"`
      - ex) STRIKE.of(2) return `"2스트라이크"`
      - ex) BALL.of(0) return `""`

# 📖 기능 목차

- ## controller
    - BullsAndCows
      - 숫자야구게임 진행을 위한 객체입니다.

- ## service
    - ProgressService
      - 게임 진행을 돕는 서비스입니다.
    - ScoreService
      - 점수를 구하는 서비스입니다.

- ## validation
    - NumberValidation
      - 주어진 입력이 올바른 값인지 검증하기 위한 객체입니다.

- ## util
    - GameCode
      - 게임 진행간 사용되는 상수(Magic Number)입니다.
    - RegexCode
      - 게임 진행간 사용되는 정규식입니다.


- ## message
    - GameProgressMessage
    - 게임 진행간 출력되는 안내메시지입니다.
    - ScoreMessage
      - 점수와 관련한 메시지입니다.

# 🕹 BullsAndCows

숫자야구게임 진행을 위한 객체입니다.

## Method

- playGame()
    - 게임을 시작하는 함수

- restart()
    - 게임을 재시작하는 함수

# 🏃 ProgressService

게임 진행을 돕는 서비스입니다.

- `initProgress()`
    - 게임을 초기화하는 함수


- `createAnswerNumber()`
    - 컴퓨터의 값(정답)을 생성하는 함수


- `getResultMessageOfGuessNumber()`
    - 사용자가 추측한 값에 따라 결과 메시지를 반환하는 함수


- `getResultOfEndGame()`
    - 게임 재시작/종료 조건을 반환하는 함수


- `isEnd()`
    - 게임이 끝났는지 구분하는함수
        - 3 스트라이크 면 게임이 끝난다.

- `checkEndOfGame()`
    - 게임 종료 여부를 판단하는 함수


- `parseStringToListInteger()`
    - String 값을 Integer List로 변환하여 반환하는 함수

# 💯 ScoreService

점수를 구하는 서비스입니다.

- `initScore()`
    - 저장된 점수를 초기화하는 함수


- `getResultScore()`
    - 결과 점수를 반환하는 함수


- `getStrikeScore()`
    - 스트라이크 점수를 구하는 함수


- `isStrikeByIndex()`
    - Index값을 참고하여 해당 값이 스트라이크인지 판별하는 함수


- `getBallScore()`
    - 볼 점수를 구하는 함수


- `isBallByIndex()`
    - Index값을 참고하여 해당 값이 볼인지 판별하는 함수


- `isNothing()`
    - '낫싱'인지 판별하는 함수

# ⚠️ NumberValidation

주어진 입력이 올바른 값인지 검증하기 위한 객체

- `validateNumber(String input)`
    - **overloading** : `validateNumber(List<Integer> input)`
    - 검증을 수행한다.
        - 숫자인지 검증 - `validateIsNumber(String input)`
        - 올바른 길이(3)인지 검증 - `validateLength(String input)`
        - 중복된 숫자가 존재하는지 검증 - `validateDuplicate(String input)`

# 💬 ScoreMessage

점수와 관련한 메시지입니다.

## 상수값

- `STRIKE("스트라이크")`
- `BALL("볼")`
- `NOTHING("낫싱")`

## Method

- `of(int number)`
    - 주어진 number에 맞춰 결과값을 만든다.
    - 예시)
        - `STRIKE.of(3)` -> `3 스트라이크`
        - `BALL.of(2)` -> `2 볼`

# 💬 GameProgressMessage

게임 진행간 출력되는 안내메시지입니다.

## 상수값

- `ASK_QUIT("게임 종료 이후 재시작, 종료를 물어보는 문구")`
- `PROGRESS_MESSAGE("게임 진행안내 문구")`
- `RESTART("재시작")`
- `CLEAR_MESSAGE("게임 클리어 시 나오는 문구)`
- `END("게임 종료");`

# 📝 GameCode

게임 진행간 사용되는 상수(Magic Number)입니다.

## 상수값

- 입력값 길이 - `MAX_NUMBER_LENGTH(3)`
- 게임종료를 위한 스트라이크 개수 - `STRIKE_COUNT_FOR_END(3)`
- 게임 재시작 코드 - `RESTART_GAME(1)`
- 게임 종료 코드 - `END_GAME(2)`

# 📝 RegexCode

게임 진행간 사용되는 정규식입니다.

## 상수값

- 숫자가 아닌 값 `REGEX_NOT_NUMBER("[^\\d]")`
- 두번 이상 중복되는 모든 값 `REGEX_HAS_DUPLICATE_VALUE("(\\w)\\1+")`
