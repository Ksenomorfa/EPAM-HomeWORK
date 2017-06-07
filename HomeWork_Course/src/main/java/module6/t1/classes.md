Задание 1. Классы коллекций
===========================
Изучите классы реализации коллекций и заполните следующую таблицу

Ordering  | Random Access | Key-Value | Pairs | Allows Duplicates | Allows Null Values | Thread Safe | Blocking Operations
----------|---------------|-----------|-------|-------------------|--------------------|-------------|--------------------
ArrayList |	Yes           | No        | No    | Yes               | Yes                | No          | No 
LinkedList| No            | No        | No    | Yes               | Yes                | No          | No
HashMap   | No            | Yes       | No    | Keys - Only one   | Yes                | No          | No
TreeMap   | No            | Yes       | No    | Keys - No         | No                 | No          | No
LinkedHashMap | No        | Yes       | No    | Keys - Only one   | Yes                | No          | No
EnumMap   | No            | Yes       | No    | Keys - No         | Keys-No, Values-Yes| No          | No
HashSet   | No            | No        | No    | Only one          | Yes                | No          | No
TreeSet   | No            | No        | No    | No                | No                 | No          | No
LinkedHashSet | No        | No        | No    | Only one          | Yes                | No          | No
EnumSet   |  No           | No        | No    | No                | No                 | No          | No
PriorityQueue| No         | No        | No    | Yes               | No                 | No          | No
LinkedBlockingQueue| No   | No        | No    | Yes               | No                 | Yes         | Yes 
ConcurrentLinkedQueue| No | No        | No    | Yes               | No                 | Yes         | No



 