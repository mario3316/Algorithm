### :book: �ڹ� ��Ʈ

- 2021/01/19 JAVA

  - ArrayList<Integer> my_list = new ArrayList<Integer>();
    (Wrapper Ŭ������ ����)

    - my_list.add(8) : ����
    - my_list.remove(7) : ����
    - my_list.clear() : ��ü ����
    - my_list.size() : ũ�� ���ϱ�
    - �ݺ��� for(Integer : my_list) �� �ݺ�
    - Iterator iter = my_list.iterator();
      while(iter.hasNext()) �� �ݺ�

  - ���ڿ��� ���ڷ� ��ȯ

    - Integer.parseInt(myString)

  - �迭 Sort
    - Arrays.sort(arr) : �������� ����
    - Arrays.sort(arr, Collections.reverseOrder()) : �������� ����

- 2021/01/20

  - System.currentTimeMills()

    - 1970.1.1���� ����� �ð��� �и��ʷ� ��ȯ

  - �迭 API

    - Arrays.toString(arr) : �迭�� ��Ʈ�����·� �ٲ���
    - ���� ����
      - int[] new_arr = arr.clone();
      - System.arraycopy(src, srcPos, dst, dstPos, length);

  - 4��, 8�� Ž��

    - 4�� // �� ���� �ð� ����
      - int[] dr = {-1, 0, 1, 0}
      - int[] dc = { 0, 1, 0, -1}
    - 8�� // �� ���� �ð� ����
      - int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }
      - int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }

  - �ڹ� �ڵ��׽�Ʈ �Է¹��� ��

    1. Scanner

       - Scanner sc = new Scanner(System.in);
       - T = sc.nextInt();
       - for�� �ȿ��� String line = sc.next(); String[] bc = line.split(" ");

    2. BufferedReader

    - BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    - StringTokenizer st = null;
    - T = Integer.parseInt(br.readLine());
    - for�� �ȿ��� st = new StringTokenizer(br.readLine());
    - �� ���忡 ���� ���� �Է¹�����
      - num[i] = Integer.parseInt(st.nextToken());
      - ���� ���� �𸦶�
        - for(int i=0; st.hasMoreTokens(); i++)

- 2021/01/21

  - String�� ���ؼ�

    - String ���� ���Ҷ��� == �� �ƴ� equals �� ���Ұ� ( Reference Type )
      - String s1 = "hello";
      - String s2 = "hello";
      - String s3 = new String("hello");
      - s1 == s2 : true // s1�� s2�� ���� "hello" �ּҸ� ������
      - s2 == s3 : false // new�� ������ hello�� ������ ���� Allocation
      - s2.equals(s3) : true // String�� ���븸�� ���Ϸ��� equals ���
    - String + �ٸ�Ÿ���� ��� String�� ��
    - String�� char�� �ٲٴ� �޼ҵ� : charAt( )
    - String�� char [] �� �ٲٴ� �޼ҵ� toCharArray( )
    - String Concat
      - - �̿�
      - String Builder �̿�
        - StringBuilder sb = new StringBuilder("");
        - String[] strArray = {"hello", ", " , "world"};
        - sb.setLength(0);
        - for( String s: strArray)
          - sb.append(s);

  - Encapsulation

    - private ( private < default < public )
    - package
    - Interface
      - ���Ǹ� �س��� ������
      - Implements�� ������

  - Inheritance

    - �ڽ��� �����ɶ� �θ� ������(heap)
      - super()�� �̿��ؼ� �θ��� �����ڵ� ȣ���
    - �ڽ��� ���赵�� �ö󰡷��� �θ� ���� �ö󰡾� ��
    - ������ �ּҴ� �θ��� �ּ� (heap)
    - ���赵�� ������ �޼ҵ常 ����� �� �ִ�

  - Object 4�� �޼ҵ� ( Object class�� �ڵ����� ��� )

    - hashCode( ) : �� ��ü�� ���� ��ü���� Ȯ�� ( hashCode�� �� )
    - toString( ): ��ü�� ������ ���ڿ��� ����� return
    - equals( ) : ������ ���Ƶ� hash code�� �޶� ��� reference type�� false�� �⺻�ε� String�� ����
    - getClass( ) : ��ü�� �����ϰ� �ִ� class�� return
    - �� 4�� Method�� Overriding�� �� ����

  - Getter�� Setter�� ����ؾ��ϴ� ����

    - ó�� ������ ����Ǵ� ��� �׿� ���� ������ �� �ִ�

  - Java ���ڿ� ����

    - String�� String[] strArr = str.split("") ���� �߶� �迭�� ����
    - Arrays.sort(strArr) �� ����
    - String.join("", strArr)�� ��ġ��

  - Java �迭 �������� ����
    - Arrays.sort(array, Collections.reverseOrder());

- 2021/01/22

  - Polymorphism

    - ��Ÿ�ڻ� : �θ� Ÿ������ �ڽ��� ����
    - ��Ÿ���� : �θ� Ÿ������ �ڽ��� ����
    - �θ���ȣ: �θ� �޼ҵ�� �ڽ��� ȣ�� (Overriding)
    - A�� �θ��̰� B�� �ڽ��϶�
      - A a = new B();
        - �ڽ��� �θ��� Ÿ������ ������ �� ����
        - �̶� ���� �޼ҵ尡 �ڽĿ��Ե� �ִٸ� �� �޼ҵ带 ȣ���ҽ� �ڽ��� �޼ҵ尡 ȣ�� ��

  - 2021/01/24

    - char Array to String

      - String str = new String(charArray);
      - StringBuilder sb = new StringBuilder();
        for(char ch: charArray)
        sb.append(ch);
        String str = sb.toString();

    - char �빮�� / �ҹ���
      - Character.toUpperCase('a');
      - Character.toLowerCase('A');
      - Ȥ�� �ƽ�Ű�ڵ� 97 - 65 ���̸� �̿��� ��ȯ

  - 2021/01/25

    - default vs protected

      - default
        - ���� ��Ű������ ���� ����
        - �ڽ� Ŭ�������� ���� �Ұ���
      - protected
        - ���� ��Ű������ ���� ����
        - �ڽ� Ŭ�������� ���� ���� ( ��� o )
      - ���� Ŭ�������� ���� �����Ϸ��� protected�� public���� �����ؾ� ��

    - this / super

      - �ڽ� Ŭ�������� this�� ��µ� �ش� ������ ������ �θ� Ŭ������ ������� ã�´�
      - ������ �θ� ����� �ùٸ��� �����ϴ� ���� super Ű����

    - ��� Class ���� �⺻������ java.lang.Object�� ��ӹ޴´� (extends Object ����)
    - this() �� �̹� �ִ� �����ڸ� �ǹ�

    - Singletone

      - �����ڸ� private���� ����
      - �ڱ� ��ü�� private static���� ������ �� public static getInstance �޼ҵ�� �� ��ü�� ��ȯ

      ```
      private static BookManager manager = new BookManager();

      private BookManager() {
        super();
        books = new Book[MAX_SIZE];
      }

      public static BookManager getInstance() {
        return manager;
      }
      ```

    - Char ��/�ҹ��� Ȯ��

      - Character.isUpperCase(c);
      - Character.isLowerCase(c);
      - return type : boolean

    - Char�� null�� �ʱ�ȭ �Ϸ��� Char c = 0;
      - Char c = null / Char c = '' �Ұ���

  - 2021/01/26

    - ������ Polymorphism

      - Type�� Method�� ũ�� ����� ������ �� ����
      - Method�� Overloading �� Overriding���� ����

        - Overloading : name�� ���Ƶ� parameter�� �ٸ�
        - Overriding : �θ� Class �� �޼ҵ带 �ڽ� Class���� ��������

      - �θ��� Type���� �ڽ� Type�� ��ü�� Reference �� �� �ִ�.
      - Phone p = new Samsung( );

        - p.toString(); // �θ� Ÿ������ �ڽ��� �����ϸ� �ڽĿ��� Overriding�� �޼ҵ常 ȣ�� ����
        - p.showInfo( ); // �ڽĿ��� �ִ� ��� ������ �޼ҵ�� ���� �Ұ���

          �� ������ (Overriding) �� �ڽĿ� ���ؼ��� �θ� Ÿ������ ������ �����ϰ� �ڽ��� �����ǵ� �޼ҵ带 ȣ���� �� �ִ�.

          Object x = new Corona();

          �� Object �� ȣ�� ����

          �� Corona�� ȣ�� ���

          �� ��, Object�� �����ִ� �Ϳ� ���ؼ��� Corona���� ȣ��

      - Overloading �� �޼ҵ�� ���� �ٸ� �޼ҵ尡 ��

        - C�� a�� A�� a�� ���� �ٸ� �޼ҵ�
        - C�� b�� B�� b�� ���� �ٸ� �޼ҵ�

        �� Overloading �Ȱ��� �ƿ� �ٸ� �޼ҵ�� ����

      - Overriding ����

        - D�� b �� B�� b �� Overriding
        - E�� b �� D �� b�� Overriding

        �� Overriding�� ���� ������? �⺻������ ��ӹ޾� ������ �ִ� �޼ҵ�

      - @Overriding Annotation

        - Ư�� Method�� ������ �ϰڴٰ� �����Ϸ����� ����ϴ� ��
        - ���� �θ� Ŭ������ �ش� Method�� ������ Compile ����

    - Interface

      - Method�� �߻�ȭ
      - � Class�� ������� ��Ҹ� �߰��ϰ� ������ ���
      - ����θ� ����ϰ� �����δ� ����
      - default method : �������� �ʾƵ� �ٷ� ����Ҽ� �ִ� �޼�
      - Method�� access modifier �� �����ϸ� �⺻������ public�� �ȴ�
      - Interface���� ������ �����ϸ� public static final �� ����� �����ѰͰ� ����.

    - �߻� Class

      - abstract keyword
      - �߻� method�� �ϳ��� ������ �߻� Class
      - �߻� Ŭ�������� �ݵ�� �߻� Method�� �ִ°��� �ƴ� ( ���� ���� �ִµ� �� �� abstract class �� �뵵�� ��� ���� )
      - ��� Method�� abstract�̸� Interface�� ����

    - �߻� Method

      - Body�� ���� Method
      - public void say(){ } �� public abstract void say( )

    - Adapter

      - �������̽��� ���Ƽ� ���� ��� �����ϴ� �δ��� �������� �߻� Class�� �߰� �ܰ踦 ����
      - Adapter������ Interface���� �����ϰ��� �ϴ� �޼ҵ带 �����ϰ� ���� ���ϴ� �޼ҵ�� abstract�� ���ܵ�
      - ���� Interface�� Implement �ؾ��ϴ� Ŭ�������� �� Adapter�� ��ӹ޾� ���

    - instanceof

      - �����ɼ� �ִ� Type���� Ȯ���ϰ� ����� boolean���� return ��

    - Inner Class

      - Ŭ���� ���ο� ������ Ŭ����
      - ��� ������ �ϳ� ó�� Ŭ������ ������ �� �ִ�
      - Ŭ���� ���ο��� new�� �����ϰ� ���

    - Anonymous Class

      - �̸��� ���� ��������� inner Class
      - �̸��� �����Ƿ� ������� �ʰ� �ѹ��� ����

      af.setFolder(new Folder() {

      @Override
      public void fold() {
      System.out.println("Anonymous-fold");
      }

      @Override
      public void open() {
      System.out.println("Anonymous-open");
      }

      });

    - final class

      - �ڽ��� ���̻� �������� ����

    - static Block

      - ó�� Instance�� ���������(Heap�� �ö� ��) �� �ѹ��� ����Ǵ� �ڵ�

    - contains( )
      - Ư�� ���ڿ��� �����ϴ��� �Ǻ�
      - book.contains(title)
      - return type : boolean

  - 2021/01/27

    - Collection

      - �ڷḦ ���������� ������ Interface
      - Set, List, Map
        - Set : ���� (�ߺ� �Ұ���), ������ ���� �ߺ��� ���� �ڷᱸ��
          - HashSet, TreeSet
          - Tree Set�� �������� ���ĵ�
      - List: ������ �ִ� �ڷ� ����
        - Array List
        - Linked List ( Queue )

    - Final
      - Final Class : ��� �Ұ���
      - Final Method : Overriding �Ұ���

  - 2021/01/28

    - Generic < >

      - Type�� Dynamic�ϰ� ������ �� �ִ� ����� ����
      - ��� Ÿ�Ե��� ���� �ڵ带 ����� ����(.java ���� ����) �� �� �޾Ƶ��ϼ� �ִ� �Ϲ�ȭ�� Ÿ��

      ```
      public class GenericContainer<T> {
      private T obj;

      public GenericContainer(){}

      public T getObj() { return obj; }

      public void setObj(T t) { obj = t; }

      }
      ```

    - Collections API

      - List (���� o �ߺ� o)
        - LinkedList
        - Stack
        - ArrayList
      - Set (���� x �ߺ�x)
        - HashSet
        - TreeSet
      - Queue (���� o �ߺ� o)
        - LinkedList
        - PriorityQueue
      - Map (Key-Value ��, ���� x, Key�ߺ�x, Value�ߺ� o)
        - HashTable
        - HashMap
        - TreeMap

    - iterator

      - Collection�� ��ȸ�ϱ� ���� interface
      - hasNext() : ������ ������ true, ������ false
      - next(): ���� ��Ҹ� return

        Iterator<Patient> itr = patientList.iterator();
        while(itr.hasNext()){
        Patient p = itr.next();
        System.out.println(p);
        }

    - PriorityQueue

      - ������ �ϴ� ������ Comparable Interface�� �����ؾ� ��

        - CompareTo( ) : �켱���� �� �޼ҵ�
        - public Class Corona implements Comparable<Corona>
        - @Override

          public int compareTo(Corona c) {

          return this.spreadSpeed - c.spreadSpeed;

          }

        - Comparable Interface�� ��ӹ��� ������ compareTo �޼ҵ带 �������̵� �ؾ� ��
        - offer() : ��� �߰�
        - poll(): �� �� ��Ҹ� �̾Ƽ� ��ȯ ( Queue������ ���� ��)
        - peek(): �� �� ��Ҹ� ��ȯ ( Queue���� �������� )

    - Comparable<T>

      - Priority queue�� ����ϴ� �� �������̽�
      - Ŭ���� ���ο� compareTo() �Լ��� �����Ѵ�

    - Comparator<T>

      - compare( ) �Լ� ����

        ```
        public int compare(int p1, int p2) {
          if (p1 > p2) {
            return 1; // 1�� ������ (��, ū�� �ڷ� (��������))
          } else if (p1 < p2) {
            return -1; // -1�̸� �״��
          } else
            return 0;
        }
        ```

      - ArrayList �����ϱ� (feat. Anonymous Class)

        - Collections.sort( list, new Comparator<Integer>( ) {

          public int compare(int p1, int p2) {

          return p1 - p2; // �ݴ�� �ϸ� ��������

          }

          }

    - Error vs Exception

      - Error : System Level , StackOverflowError

        �ڵ峪 ȯ������ ����

      - Exception : App level, IOException

    - Exception

      - RuntimeException : ����� �߻��ǹǷ� �����Ҽ� ����
        - ex ) NullPointer, ArrayIndexOutOfBounds
      - Other Exceptions : ���� �����ϹǷ� �ڵ� �ۼ��� ó��
        - ex) IOException, SQLException

    - Exception ó��

      - try-catch-finally
        - try : Exception�� �߻��Ҽ� �ִ� �ڵ�
        - catch(A e) : Exception �߻��� �����ϴ� �ڵ�
        - finally : Exception�� �߻��ϵ� ���ϵ� �ݵ�� ����Ǵ� �ڵ�
      - throws
        - ���� ȣ���� �޼ҵ忡�� ó���ϵ��� å���� ����
      - try-catch-throw
        - ���� ó���ϰ� ȣ���� �������� ó���ϰ�
