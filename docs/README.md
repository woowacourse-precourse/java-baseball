정리한 기능 목록 단위
==
Structure
--
1. 실행문구 --> 입력
2. 결과 출력
    1. 맞춘 개수파악
       1. 맞은 개수 = 스트라이크 / 틀린 개수 = 볼
       2. 하나도 안 맞은 경우
       3. 모두 맞힌 경우
    2. 결과출력
3. 재시작유무(1=재시작,2=종료)


유의 : 

depth 2까지허용 // 함수는 한가지 행동만 // TestCase생성
camp.nextstep.edu.missionutils Library사용
==> pickNumberInRange() readLine()

---
커밋시 생각해야할점
==
-커밋 메시지 컨벤션
==> Udacity의 컨벤션 의 프레임을 사용


1. type : Subject //필수요소
2. body
3. footer 

명령형을 사용해야한다.

ex)
fix: CardList 컴포넌트 클릭 시 공백으로 나오는 오류 수정


모바일 버전에서 CardList의 img 부분 클릭 시 공백으로 나오는 오류 수정.
PC버전은 이상없음.

type
--
::

feat: 새로운 기능

fix: 버그 해결

docs: 문서 변경

style: formatting, 놓친 세미콜론 등... 코드의 변경은 없음

refactor: 코드 리팩토링

test: 테스트 코드 추가 혹은 테스트 코드 리팩토링. 코드의 변경은 없음

chore: 패키지 매니저 구성, 빌드 작업 업데이트. 코드의 변경은 없음

::

-정리한 기능 목록 단위에 맞춘 commit

---
커밋을 정리하면 좋은 점
==
더 좋은 커밋 로그 가독성

더 나은 협업과 리뷰 프로세스

더 쉬운 코드 유지보수

---