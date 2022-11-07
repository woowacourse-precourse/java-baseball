## 기능 목록

1. main

   description: 게임을 종료하거나 예외 입력이 발생할 때 까지 게임 반복. (do while 사용)

2. 중복X, 랜덤 3자리 수 생성
    - makeAnswer
        1. description: 1~9까지 서로 다른 세 자리의 수 생성
        2. input: x
        3. ouput: answer(String)
3. 게임 플레이
    - playBaseball
        1. description: 정답을 맞출 때 까지 반복적으로 입력을 받으며 플레이
        2. input: answer(String)
        3. ouput: x
4. 입력 예외 여부 확인
    - checkException
        1. description: 맞추는 단계에서 입력의 예외 여부 확인
        2. input: input(String)
        3. ouput: isOK(boolean)
    - checkDuplicateNum
        1. description: 입력값 중 중복숫자 여부 확인
        2. input: input(String)
        3. output: isDuplicate(boolean)
5. 입력받은 수의 strike 계산
    - calStrike
        1. description: 입력값과 정답을 비교하여 숫자와 위치 모두 일치하는 수 계산
        2. input: answer(String), input(String)
        3. ouput: strike(int)
6. 입력받은 수의 ball 계산
    - calBall
        1. description:입력값과 정답을 비교하여 일치하는 숫자의 수 계산
        2. input: answer(String), input(String)
        3. ouput: ball
7. 결과 출력
    - printResult
        1. description: strike와 ball 수를 토대로 결과 출력, 모두 0일 경우 낫싱. `ball = ball-strike.`
        2. input: strike(int), ball(int)
        3. ouput: x
8. 새 게임 여부 확인
    - checkRepeate