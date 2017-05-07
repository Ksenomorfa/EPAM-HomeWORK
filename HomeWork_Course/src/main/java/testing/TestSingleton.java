package testing;

public class TestSingleton {
    public static void main(String[]args){
       // AntiSingleton s1  = new AntiSingleton();
        AntiSingleton singleton = AntiSingleton.getInstance();
        System.out.println(singleton);
        AntiSingleton singleton2 = AntiSingleton.getInstance();
        System.out.println(singleton2);
    }
}

class AntiSingleton {

    private static AntiSingleton instance;
    private AntiSingleton (){}
     public static synchronized AntiSingleton getInstance () {
         if (instance == null) {
             instance  =
                     new AntiSingleton();
         }
        return instance;
     }
}
