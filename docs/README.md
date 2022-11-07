## ❗기능 정의

### ✅ 기능 목록
1. 게임시작 문구 출력
   <br><br>
2. 상대방(컴퓨터): 서로 다른 3자리수 생성
    - `camp.nextstep.edu.missionutils.Randoms` 활용
    - `return ArrayList<Integer>`
      <br><br>
3. 사용자: 숫자 입력
    - `camp.nextstep.edu.missionutils.Console` 활용
    - 3자리수 입력(⭕)
        - `return ArrayList<Integer>`
    - 잘못된 값 입력(❌)
        - `IllegalArgumentException` 발생
            - 포함 문자?
            - 3자리 숫자?
            - 각 1~9 숫자?
            - 서로 다른 숫자?
              <br><br>
4. 상대방(컴퓨터) 숫자와 사용자 숫자 비교
    - `ArrayList<Integer>` 끼리 비교
        - 같은수 - 같은자리: 스트라이크
        - 같은수 - 다른자리: 볼
        - 모두 다른수: 낫싱
        - `return ArrayList<Integer>`
            - [볼의 개수, 스트라이크의 개수]
              <br><br>
5. 비교 결과값 출력
    - `ArrayList<Integer>` 활용
      <br><br>
6. 비교 결과값 통해 게임 상황 판단
    - 숫자 일치(⭕)
        - 게임 종료 문구 출력
        - 사용자: 숫자 입력
            - 게임 재시작(1) 입력(⭕)
                - `camp.nextstep.edu.missionutils.Console` 활용
                - 게임 재시작 문구 출력
                - 게임 재시작
                    - <u>2. 상대방(컴퓨터): 서로 다른 3자리수 생성</u>
            - 게임 종료(2) 입력(⭕)
                - `camp.nextstep.edu.missionutils.Console` 활용
                - 게임 종료
            - 잘못된 값 입력(❌)
                - `IllegalArgumentException` 발생
                    - 1 숫자?
                    - 2 숫자?

    - 숫자 일치(❌)
        - <u>3. 사용자: 숫자 입력</u>