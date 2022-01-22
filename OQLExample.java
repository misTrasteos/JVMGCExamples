///usr/bin/env jbang "$0" "$@" ; exit $?

package oql.example;

public class OQLExample {

    static class A{
        B b;
    }
    
    static class B{
        C c;
    }

    static class C{
        D d;
    }

    static class D{}

    public static void main(String... args) throws Exception {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.b = b;
        b.c = c;
        c.d = d;
        
        Thread.currentThread().join();
    }
}
