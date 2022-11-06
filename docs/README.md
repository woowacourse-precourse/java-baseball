### 기능 구현 목록
- [x] 게임 시작 함수
    - [x] 컴퓨터가 임의의 서로 다른 수 3개를 선택
    - [x] 사용자 입력 함수 호출
    - [x] 비교 함수 호출
    - [x] 결과 출력 함수 호출
    - [x] 게임 결과가 0이라면 오답이므로 숫자 입력 다시 받음
    - [x] 게임 결과가 1이라면 게임 새로 시작
    - [x] 게임 결과가 2이라면 게임 종료
- [x] 컴퓨터 수 생성 함수
    - [x] camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- [x] 사용자 입력 함수
    - [x] 사용자에게서 서로 다른 수 3개를 입력
        - [x] camp.nextstep.edu.missionutils.Console의 readLine()을 활용
- [x] 사용자 입력 수의 예외 처리
    - [x] 3자리 수 미만 혹은 초과로 입력하는 경우
    - [x] 서로 다른 수가 아닌 경우
    - [x] 1부터 9 사이 수가 아닌 경우
- [x] 컴퓨터와 사용자의 수를 비교하는 함수
    - [x] "스트라이크", "볼" 개수 저장하는 변수 생성
    - [x] 같은 자리에 있는지 확인하는 함수
        - [x] 같은 자리에 있다면 스트라이크+1
    - [x] 같은 수를 포함하는지 확인하는 함수
        - [x] 다른 자리에 있고 포함만 된다면 볼+1
- [x] 결과 출력하는 함수
- [x] 게임 재개 여부 함수
    - [x] 0(오답)을 선택하면 0반환
    - [x] 1(재시작)을 선택하면 게임 시작 함수 호출 후 1반환
    - [x] 2(종료)를 선택하면 2반환
### 프로그램 구조
* Application
    * main
    * continueGame
    * playGame
* GameOutput
    * printResult
* Comparison
    * compare
    * locate
    * contain
* NumberChoice
    * computerPick
    * userPick
* Validation
    * isValid
    * isLength
    * isRange
    * isDiff
### 테스트 항목
* ApplicationTest
    * 게임종료_후_재시작
    * 예외_테스트_길이
    * 예외_테스트_범위
    * 예외_테스트_중복
* Comparison
    * 스트라이크
    * 스트라이크_볼
    * 볼
    * 낫싱

