# 구현 기능 목록

- 컴퓨터 정답 생성(3자리 1~9 사이의 수로 구성)
   - 인자: 없음
   - 내용: Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
   - ouput: int


- 숫자 입력 받기(3자리 1~9 사이의 수)
    - 인자: 없음
    - 내용: 입력 받은 값들의 validation, 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다. 적절한 값의 경우 return int
    - ouput: int or throw illelgalArgumentException


- 입력된 값과 정답 비교
    - 인자: int answer, int userGuess
    - 내용: 정답과 유저 입력값 3자리를 비교해 [스트라이크 수, 볼 수] 계산
    - ouput: [스트라이크 수, 볼 수]


- 비교 결과를 통해 힌트 출력
    - 인자: int [] comparedResult
    - 내용: 스트라이크와 볼 수를 출력, 만약 둘다 0일 경우 낫싱을 출력. 스트라이크 3개인 경우 정답 조건 만족시 새 게임 또는 종료 선택 메세지 출력
    - ouput: 없음
    