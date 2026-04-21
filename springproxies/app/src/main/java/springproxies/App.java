package springproxies;

import springproxies.classes.Man;
import springproxies.classes.Person;
import springproxies.classes.PersonInvocationHandler;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        Man curator = new Man("Curator",22,"Azamgarh","india");

        ClassLoader curatorClassLoader = curator.getClass().getClassLoader();

        Class[] interfaces = curator.getClass().getInterfaces();

        Person proxyCurator = (Person) Proxy.newProxyInstance(curatorClassLoader,interfaces,
                new PersonInvocationHandler(curator));

        proxyCurator.introduce(curator.getName());
        proxyCurator.sayAge(curator.getAge());
        proxyCurator.sayWhereFrom(curator.getCity(), curator.getCountry());

    }
}
