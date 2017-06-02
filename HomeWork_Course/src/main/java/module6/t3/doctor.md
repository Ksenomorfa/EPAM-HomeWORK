Задание 3. Ссылки на коллекции
------------------------------
Определена иерархия классов:

class MedicalStaff{}<br>
class Doctor extends MedicalStaff{}<br>
class Nurse extends MedicalStaff{}<br>
class HeadDoctor extends Doctor{}<br>

Укажите корректные и некорректные операторы. Дайте ответу пояснение.

Operator | correct	| not correct| Comment 
---------|----------|------------|--------
Doctor doctor1 = new Doctor();| V |		|  We can initialise link with it's class
Doctor doctor2 = new MedicalStaff();| | V | Can't initialize link with it's parent's class
Doctor doctor3 = new HeadDoctor();| V | | Can initialise link with it's child's class
Object object1 = new HeadDoctor();|	V | | Every class can be initialise in link to Object, because it is parent of all classes
HeadDoctor doctor5 = new Object();| | V | Can't initialize link with it's parent's class
Doctor doctor6  = new Nurse();| | V | Nurse isn't extended from Doctor
Nurse nurse = new Doctor();| | V | Doctor isn't extended from Nurse
Object object2 = new Nurse();| V | | Every class can be initialise in link to Object, because it is parent of all classes
List\<Doctor> list1= new ArrayList\<Doctor>();|V  | | Inheritance works for types (for lists in that situation)
List\<MedicalStaff> list2 = new ArrayList\<Doctor>();| | V | Generics don't work with inheritance, it must be <.. extends ...>
List\<Doctor> list3 = new ArrayList\<MedicalStaff>();| | V | Generics don't work with inheritance, it must be <.. extends ...>
List\<Object> list4 = new ArrayList\<Doctor>();| | V  | Generics don't work with inheritance, it must be <.. extends ...>
List\<Object> list5 = new ArrayList\<Object>();| V | | Inheritance works for types (for lists in that situation)
