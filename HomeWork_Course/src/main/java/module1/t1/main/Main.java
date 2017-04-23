package module1.t1.main;

import module1.t1.logic.Logic;
/**
* <p>Compiling from command line with command:</p>
* <code>C:\Users\Полина\IdeaProjects\EPAM-HomeWORK\HomeWork_Course>
 *     javac -d bin -cp src\main\java\ src\main\java\module1\t1\main\Main.java</code>
* <p>Running from command line with command:</p>
* <code>C:\Users\Полина\IdeaProjects\EPAM-HomeWORK\HomeWork_Course>
 *     java -cp ./bin module1.t1.main.Main</code>
* <p>Result:</p> I am string in Logic
*/
public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        System.out.println(logic.method());
    }
}
