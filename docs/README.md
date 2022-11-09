# 기능 구현 목록


| 모듈 (메서드, 묶음 단위) | 기능 이름 | 상세 설명 |
| --- | --- | --- |
| #1. 정수 난수 배열 생성 모듈 | 1-1) 배열 초기화 | 총 3개의 정수를 담을 수 있는 길이 3의 정수 배열을 초기화한다. |
|  | 1-2) 정수 난수 생성 | camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange(1,9)을 이용해 정수 난수를 생성한다. |
|  | 1-3) 배열에 정수 난수 추가 | 난수 배열에 이미 포함되어 있지 않은 수이면서, 배열 길이가 3이 아니라면 추가한다. 포함되어 있는 수라면, 다시 난수를 생성하도록 한다. |
| #2. 사용자 숫자 입력 | 2-1) 사용자에게 숫자 입력 받기 | camp.nextstep.edu.missionutils.Console의 readLine() 을 이용해 사용자 입력을 받는다. |
| #3. 입력 값 에러 이벤트 처리 | 3-1) 정수 배열 초기화 | 사용자로부터 입력 받은 3자리의 정수를 담을 배열을 초기화한다. |
|  | 3-2) 정수 여부 확인 | 정수가 3자리 숫자인지 확인한다. 아니라면, IllegalArgumentException  |
|  | 3-3) 3자리 확인 | 정수가 3자리 숫자인지 확인한다. 아니라면, IllegalArgumentException  |
|  | 3-4) 서로 다른 수 확인 | 사용자가 입력한 서로 다른 세 자리 수가 모두 다른 수인지, 정수 배열에 포함되어 있는 수인지  확인한다. 동일한 수가 이미 있다면, IllegalArgumentException  |
|  | 3-5) 범위 확인 (1~9) | 각 3자리 수가 모두 1~9 사이의 숫자인지 확인한다. (0 포함 여부 확인) 아니라면, IllegalArgumentException  |
|  | 3-6) 배열에 정수 추가 | 위의 모든 조건들을 만족하면, 해당 정수를 배열에 추가한다. |
| #4. 숫자 맞히기 | 4-1) 볼 개수 구하기 | 사용자가 입력한 수로 만든 정수 배열의 요소가 컴퓨터가 생성한 난수 배열의 3개 중 몇 개 포함되어 있는지 개수를 구한다. |
|  | 4-2) 볼 개수 확인 | 개수가 0이라면 “낫싱”을 출력하고, 아니라면 볼 개수 중 스트라이크 개수를 구하도록 한다. |
|  | 4-3) 스트라이크 개수 구하기 | 사용자가 입력한 수의 각 자리의 수가 난수 배열의 위치와 동일한 것의 개수를 구한다. 그 개수만큼 스트라이크 개수에서 뺀다. |
|  | 4-4) 볼, 스트라이크 개수 출력 | 볼의 개수가 b, 스트라이크 개수가 s일 때, “b볼, s스트라이크” 형식으로 출력한다. 볼가 0이라면 스트라이크만 출력하고, 스트라이크가 0이라면 볼만 출력한다. |
|  | 4-5) 스트라이크 개수 확인 | 스트라이크의 개수가 3이라면, “3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요” 를 출력한다. |
| #5. 사용자 다음 명령 입력 | 5-1) 사용자에게 다음 명령 숫자 입력 받기 | camp.nextstep.edu.missionutils.Console의 readLine() 을 이용해 사용자 입력을 받는다. |
|  | 5-2) 입력 값 확인과 에러 처리 | 입력한 값이 1 또는 2인지 확인한다. 아니라면, IllegalArgumentException  |
|  | 5-3) 다시 게임 시작  | 입력 값이 2라면 다시 게임을 시작한다. (사용자에게 숫자를 입력 받는 기능부터 시작) |
|  | 5-4) 게임 종료 | 입력 값이 1이라면 게임을 종료한다. |
|  |  |  |


### 순서도

<details>
    <summary>자세히 보기 </summary>

### 전체 순서도

<div style="text-align: center">
    <img src="https://k.kakaocdn.net/dn/cuPvdZ/btrQDFSw62b/PkUZkGg9yQoCO4tcvT3M0k/img.png" height="500" alt="">  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbBmGeG%2FbtrQHBvTv89%2FiGu9LNo8vVBoFsHgdzrFFK%2Fimg.png" height="500" alt="">
</div>

### RandomNumberGenerator
<div style="text-align: center">
    <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2Fuik0f%2FbtrQErHxxsS%2FGwrWLEY0UUu2KVkNAn2rlK%2Fimg.png" width="200" alt="">
</div>

### HandleErrorForUserInput

<div style="text-align: center">
    <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FbeY74v%2FbtrQJioJfb6%2FI63fVNYP52c1LXaOPgUHT1%2Fimg.png" width="400" alt="">
</div>

### CountStrikesAndBalls
<div style="text-align: center">
    <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FQQ4Bh%2FbtrQFw2JV6o%2FCprMBXE3OTMNolITvPh24K%2Fimg.png" width="300" alt="">
</div>
</details>


### 각 기능에 대한 테스트들

<details>
    <summary>자세히 보기 </summary>

| 테스트 대상 기능번호 | 테스트 이름  | 입력 값 예시 | 예상 결과 / 에러처리 |
| --- | --- | --- | --- |
| 3-2 | 정수 외에 다른 문자를 포함하는 수 | 34Y, hello, 2B1, 3B, AB, A | IllegalArgumentException |
| 3-3 | 3자리 수가 아닌 수 | 12, 2444 | IllegalArgumentException |
| 3-4 | 동일한 숫자 발견 | 799, 252, 112 | IllegalArgumentException |
| 3-5 | 0을 포함한 수 | 980, 012, 305 | IllegalArgumentException |
| 4-1 볼 개수 구하기 (정답: 123) | 3볼 | 231, 312 | s: 3 |
|  | 2볼 1스트라이크 | 132, 321, 213 | s: 3 |
|  | 1볼 2스트라이크 | 127, 623, 193 | s: 3 |
|  | 3스트라이크 | 123 | s: 3 |
|  | 2볼 | 612, 219 | s: 2 |
|  | 1볼 | 871, 762, 651 | s: 1 |
|  | 0스트라이크 | 876, 954 | 0 “낫싱” 출력 |
| 4-2 스트라이크 개수 구하기 (정답: 123) | 2볼 1스트라이크 | 132, 321, 213 | s: 2, b: 1 |
|  | 1볼 2스트라이크 | 127, 623, 193 | s: 1, b: 2 |
|  | 3스트라이크 | 123 | b: 3 |
| 5-2 사용자 다음 명령  | 1과 2가 아닌 정수, 문자열, 문자 | 0, 3, 142, ‘y’, ‘hello’, 24 | IllegalArgumentException |
| 5-3 게임 재시작 | 2인 경우 재시작 | 2 | “숫자를 입력하세요 : “ 부터 시작 |
| 5-3 게임 종료 | 1인 경우 종료 | 1 |  |

</details>