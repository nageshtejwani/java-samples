
sealed interface Animal permits Dog,Cat,Aerial {
    void  sound();
}

final class Dog implements Animal{

    @Override
    public void sound() {
        //implemenetation
    }
}

non-sealed class Cat implements Animal{


    @Override
    public void sound() {
        //implemenetation
    }
}

sealed class Aerial implements Animal{

    @Override
    public void sound() {
       //implemenetation
    }
}

final class Eagle extends Aerial {

    //implementation
}





public class Sample {
}
