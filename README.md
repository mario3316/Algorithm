# Algorithm

---

### TODO

- 프로그래머스 1단계, 2단계, 3단계
- 파이썬 문법 익히기

---

### Study Flow

- **_Implementation_**
- Greedy
- BFS/DFS
- DP
- Hash

---

### 문제 풀이

- Programmers

  - Lv.1
    - ~~크레인 인형뽑기 게임 (2019 카카오 겨울 인턴 코딩테스트)~~
    - ~~두개 뽑아서 더하기~~
    - ~~완주하지 못한 선수~~
    - ~~모의고사~~
    - ~~체육복~~
    - ~~2016년~~
    - ~~3진법 뒤집기~~
    - ~~비밀지도 (2018 카카오 코딩테스트 1차)~~

- BOJ

---

### 새롭게 익힌 사실

- 2021/01/12

  - List의 맨 마지막 요소를 접근하려면 -1 인덱스를 사용 (단, 리스트가 비어있지 않아야 함)
  - 파이썬은 ++, -- 가 되지 않는다. a += 1 같은 식으로 해야함
  - 파이썬은 not연산자 (!) 를 지원하지 않는다 -> not
  - 배열을 반복문으로 참조할때
    - for i in list로 하면 index가 아닌 list의 값들을 참조
    - 인덱스로 반복하려면 for i in range(len(list))를 사용
  - List에서 인덱스로 요소를 삭제할때 del, remove, pop이 있음 -> 더 찾아볼 것

- 2021/01/14

  - 리스트 정렬 list.sort()
  - 리스트 거꾸로 뒤집기 list.reverse()
  - 리스트 정렬된 결과 반환 sorted_list = sorted(original_list)
  - 리스트에 요소 있는지 확인 if num in list: / else :
  - Hash 자료구조

    - Key, Value 쌍
    - 파이썬에서는 Dictionary 형태로 구현
    - 장점 : 데이터 저장 / 검색 속도가 빠르다
    - 단점 : 저장공간이 많이 필요하다
    - 시간복잡도
      - 일반적인 경우 : O(1)
      - 최악의 경우 : O(n)
        ![Hash](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FRf9ew%2FbtqBD2nxuS2%2FNcjU5klHVOqPfEm28syiFk%2Fimg.png)

  - 딕셔너리

    - d = { } 로 선언 (필수)
    - d['age'] = 27 // age 라는 Key로 27이라는 Value 삽입
    - d['age'] // key로 Value에 접근
    - d.get('age') // Key로 Value 검색
    - 'age' in d // 'age' 라는 Key가 딕셔너리에 존재하는가 ?
    - d.keys() // 딕셔너리의 모든 Key 들을 List로 반환
    - d.values() // 딕셔너리의 모든 Value 들을 List로 반환
    - 위 두 List를 정렬하고 싶다면 sorted(d.keys()), sorted(d.values())
    - d.items() // 딕셔너리의 모든 Key, Value 쌍을 Tuple의 List형태로 반환
    - Value로 Key 찾기
      - dict = {'a': 1, 'b': 0, 'c': 0, 'd': 0}
        for key, value in dict.items():
        if value == 1:
        print(key)

  - List에서 인덱스로 삭제하려면 del(a[1])
  - List로 값으로 삭제하려면 a.remove(3)
  - 조합 구하기
    - combinations(list, 2) : list 안에 2개의 요소로 구할 수 있는 모든 조합을 반환
    - list(combinations(list,2)) 로 하면 모든 조합의 list
  - Set (집합)

    - 중복을 제외한 값들을 저장하고 싶을때 Set 사용
    - 선언 s = set()
    - 삽입 s.add(2)
    - 삭제 s.remove(2)

  - List Comprehense

    - [A for B in C]
      - A : 리스트에 저장될 형태
      - B : C를 순회하는 요소
      - ex) new_list = [x+1 for x in range(10)]
        : 1~10까지 담은 새로운 리스트 생성

  - enumerate()
    - 반복문 사용시 몇번째 반복문인지 확인하고 싶을때 (즉, index가 필요할때)
    - 인덱스 번호와 원소를 tuple형태로 반환
    - for i, value in enumerate(my_list):

- 2021/01/15

  - set으로 차집합 구현 가능 ( A 리스트에는 있고 B 리스트에는 없는 것을 찾고싶을때)
    - new_list = set(A) - set(B)
  - 리스트 slice
    - [인덱스a이상: 인덱스b미만]
    - a[0:2] : 0,1 인덱스
    - a[0:] : 0부터 끝까지
    - a[:3] : 0부터 2까지

- 2021/01/16

  - 파이썬은 정수끼리 나누기 ( / ) 하면 실수가 나옴 ( 5 / 2 == 2.5)
  - 원래처럼 몫만 나오게 하려면 // 연산 사용 ( 5 // 2 == 2 )
  - list 뒤집기 list.reverse()
  - x의 y 승 구하기 : x\*\*y

- 2021/01/17
  - 2진수 변환 bin(num)
    - 0b로 시작하는 str이 나오기때문에 2진수 값만 취하려면 [2:] 로 slice
  - 8진수 변환 oct(num)
    - 0o로 시작하는 str이 나오기때문에 8진수 값만 취하려면 [2:] 로 slice
  - 16진수 변환 hex(num)
    - 0x로 시작하는 str이 나오기때문에 16진수 값만 취하려면 [2:] 로 slice

---

- 2021/01/19 JAVA로 변경

  - ArrayList<Integer> my_list = new ArrayList<Integer>();
    (Wrapper 클래스로 선언)

    - my_list.add(8) : 삽입
    - my_list.remove(7) : 삭제
    - my_list.clear() : 전체 삭제
    - my_list.size() : 크기 구하기
    - 반복문 for(Integer : my_list) 로 반복
    - Iterator iter = my_list.iterator();
      while(iter.hasNext()) 로 반복

  - 문자열을 숫자로 변환

    - Integer.parseInt(myString)

  - 배열 Sort
    - Arrays.sort(arr) : 오름차순 정렬
    - Arrays.sort(arr, Collections.reverseOrder()) : 내림차순 정렬

- 2021/01/20

  - System.currentTimeMills()

    - 1970.1.1부터 경과한 시간을 밀리초로 반환

  - 배열 API

    - Arrays.toString(arr) : 배열을 스트링형태로 바꿔줌
    - 깊은 복사
      - int[] new_arr = arr.clone();
      - System.arraycopy(src, srcPos, dst, dstPos, length);

  - 4방, 8방 탐색

    - 4방 // 상 부터 시계 방향
      - int[] dr = {-1, 0, 1, 0}
      - int[] dc = { 0, 1, 0, -1}
    - 8방 // 상 부터 시계 방향
      - int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }
      - int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }

  - 자바 코딩테스트 입력받을 때

    1. Scanner

       - Scanner sc = new Scanner(System.in);
       - T = sc.nextInt();
       - for문 안에서 String line = sc.next(); String[] bc = line.split(" ");

    2. BufferedReader

    - BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    - StringTokenizer st = null;
    - T = Integer.parseInt(br.readLine());
    - for문 안에서 st = new StringTokenizer(br.readLine());
    - 한 문장에 여러 정수 입력받을때
      - num[i] = Integer.parseInt(st.nextToken());
      - 정수 개수 모를때
        - for(int i=0; st.hasMoreTokens(); i++)

- 2021/01/21

  - String에 대해서

    - String 끼리 비교할때는 == 이 아닌 equals 로 비교할것 ( Reference Type )
      - String s1 = "hello";
      - String s2 = "hello";
      - String s3 = new String("hello");
      - s1 == s2 : true // s1과 s2는 같은 "hello" 주소를 참조함
      - s2 == s3 : false // new로 생성된 hello는 무조건 따로 Allocation
      - s2.equals(s3) : true // String의 내용만을 비교하려면 equals 사용
    - String + 다른타입은 모두 String이 됨
    - String을 char로 바꾸는 메소드 : charAt( )
    - String을 char [] 로 바꾸는 메소드 toCharArray( )
    - String Concat
      - - 이용
      - String Builder 이용
        - StringBuilder sb = new StringBuilder("");
        - String[] strArray = {"hello", ", " , "world"};
        - sb.setLength(0);
        - for( String s: strArray)
          - sb.append(s);

  - Encapsulation

    - private ( private < default < public )
    - package
    - Interface
      - 정의만 해놓은 껍데기
      - Implements로 구현함

  - Inheritance

    - 자식이 생성될때 부모가 생성됨(heap)
      - super()를 이용해서 부모의 생성자도 호출됨
    - 자식의 설계도가 올라가려면 부모가 먼저 올라가야 함
    - 생성된 주소는 부모의 주소 (heap)
    - 설계도에 공개된 메소드만 사용할 수 있다

  - Object 4개 메소드 ( Object class는 자동으로 상속 )

    - hashCode( ) : 두 객체가 같은 객체인지 확인 ( hashCode로 비교 )
    - toString( ): 객체의 값들을 문자열로 만들어 return
    - equals( ) : 내용이 같아도 hash code가 달라서 모든 reference type은 false가 기본인데 String만 예외
    - getClass( ) : 객체가 참조하고 있는 class를 return
    - 위 4개 Method는 Overriding할 수 있음

  - 자바 메모리 구조

  ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/18d1404c-0445-4ae5-8821-2376f792623c/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/18d1404c-0445-4ae5-8821-2376f792623c/Untitled.png)

  - Getter와 Setter를 사용해야하는 이유

    - 처리 로직이 변경되는 경우 그에 쉽게 대응할 수 있다

  - Java 문자열 정렬

    - String을 String[] strArr = str.split("") 으로 잘라서 배열로 만듬
    - Arrays.sort(strArr) 로 정렬
    - String.join("", strArr)로 합치기

  - Java 배열 내림차순 정렬
    - Arrays.sort(array, Collections.reverseOrder());

- 2021/01/22
  - Polymorphism
    - 부타자생 : 부모 타입으로 자식을 생성
    - 부타자참 : 부모 타입으로 자식을 참조
    - 부메자호: 부모 메소드로 자식을 호출 (Overriding)
    - A가 부모이고 B가 자식일때
      - A a = new B();
        - 자식을 부모의 타입으로 생성할 수 있음
        - 이때 같은 메소드가 자식에게도 있다면 그 메소드를 호출할시 자식의 메소드가 호출 됨
