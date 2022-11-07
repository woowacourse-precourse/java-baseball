# 숫자 야구 게임

---

## 구현할 기능 목록


- [x] 3자리의 랜덤 숫자 생성 기능
- [x] 숫자 입력 기능
- [x] 입력 받은 문자 검증 기능
- [x] 볼,스트라이크 체크 기능
- [x] 결과 출력 기능
- [x] 정답 확인 기능
- [x] 정답 시 종료/재시작 탐색 기능
- [x] 야구게임 실행 기능

---

## 수정 사항


### 3자리의 랜덤 숫자 생성 기능
- 요구사항에 맞게 3자리 랜덤 숫자 생성 메서드 변경
    

    //변경 전
    > Return Randoms.pickUniqueNumbersInRange(1, 9, 3); 
    
    // 변경 후 
    > List<Integer> list = new ArrayList<>();

        while (list.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            // 숫자 중복 검사
            if(isNotDuplicatedNumber(list , number)){
                list.add(number);
            }
        }
    Return list;

### 게임 종료, 재시작 메세지 위치 변경

    // 변경 전
    announcedResult()
    // 변경 후
    reGameOrEnd() 

### 야구 게임 실행 기능

    // 변경 전
    while문 내부에서 모든 코드가 진행되었습니다.
    // 변경 후
    playBaseBall() 실행 메서드를 이용하여 최대 깊이가 3을 넘지 않도록 수정하였습니다.

### 입력 받은 문자 검증 수정
정규표현식을 변경하여 return 값 변경으로 ! 표현식을 삭제하였습니다.
    
    // 변경 전
    if (!Pattern.matches("[0-9]+$", usersNumber)) {
            return false;
        }
    // 변경 후
    if (Pattern.matches("[0-9]+$", usersNumber)) {
            return true;
        }

### 문자열 검증 후 예외 수정

조건과 다른 예외 코드 수정 ( 테스트 케이스 덕분에 발견하였습니다.)

    // 변경 전
    IllegalStateException
    // 변경 후
    IllegalArgumentException


### 구현 기능 추가

- 결과 출력 기능
- 정답 확인 기능
- 야구 게임 실행 기능
- 볼,스트라이크가 둘 다 0개 일 때 낫싱 출력
