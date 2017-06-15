Задание 1. Классы коллекций
===========================
Изучите классы реализации коллекций и заполните следующую таблицу

Ordering  | Random Access | Key-Value | Allows Duplicates | Allows Null Values | Thread Safe | Blocking Operations
----------|---------------|-----------|-------------------|--------------------|-------------|--------------------
ArrayList |	Yes           | No        | Yes               | Yes                | No          | No 
LinkedList| No            | No        | Yes               | Yes                | No          | No
HashMap   | Yes            | Yes       | Keys - No         | Keys - Only one    | No          | No
TreeMap   | Yes            | Yes       | Keys - No         | Keys - No          | No          | No
LinkedHashMap | No        | Yes       | Keys - No         | Keys - Only one    | No          | No
EnumMap   | No            | Yes       | Keys - No         | Keys - No          | No          | No
HashSet   | No            | No        | No                | Only one           | No          | No
TreeSet   | No            | No        | No                | No                 | No          | No
LinkedHashSet | No        | No        | No                | Only one           | No          | No
EnumSet   |  No           | No        | No                | No                 | No          | No
PriorityQueue| No         | No        | Yes               | No                 | No          | No
LinkedBlockingQueue| No   | No        | Yes               | No                 | Yes         | Yes 
ConcurrentLinkedQueue| No | No        | Yes               | No                 | Yes         | No



 