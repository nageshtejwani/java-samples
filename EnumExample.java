public class EnumExample {

    enum Fruits {APPLE,MANGO,MELON};

    public static void  someOperation(){

        Fruits f = Fruits.APPLE;
        switch (f){
            case APPLE -> System.out.println("APPLE");

            case MANGO -> System.out.println("MANGO");

            case MELON -> System.out.println("MELON");

        }


    }
    public static void main(String args[]){
        EnumExample.someOperation();
    }
}
