### 우아한 테크 코스 2주차 과제: 숫자 야구
- [ ] 1차 조건문: 입력값 확인
  - camp.nextstep.edu.missionutils.Console.readLine() 사용하여 input 받기
  - 3자리 수
  - 각 자리 숫자가 달라야함
  - 게임이 끝났다면:
    - 1 = 재시작
    - 2 = 종료
  - 위의 조건들을 전부 통과할 시, 
    - "숫자 야구 게임을 시작합니다." 출력 
    - 각 자리의 수가 다른 3자리 수(int computer) 생성
      - camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용
  - 잘못됐으면 IllegalArgumentException 발생, 어플리케이션 종료

- [ ] 1차 반복문: 숫자 야구 게임 시작
  - [ ] 1-1차 반복문: 자릿수 별로 같은 숫자인지 비교
    - 같은 수가 같은 자리에 있다면(true일 시) 스트라이크(int strike) +1
    - computer와 input값이 똑같다면(if (strike == 3) {}),
      - "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
      - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
      - 1 과 2 중 하나를 받을 준비

  - [ ] 1-2차 반복문: input 값의 숫자 중 computer의 숫자와 같지만 다른 자리에 있는 숫자를 찾음
    - 같은 수가 다른 자리에 있다면(true일 시) 볼(int ball) +1

  - [ ] 1-1차 조건문: 만약 숫자가 아예 다르다면(if (strike == 0 && ball == 0) {}), 
    - "낫싱" 출력

### 클린 코드 요구 사항
- [ ] indent depth 2 이하
- [ ] 삼항 연산자(condition ? true:false) 사용 X
- [ ] 1함수 1기능