///usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA_OPTIONS -XX:+UseSerialGC -Xlog:gc*
//JAVA_OPTIONS -Xms16m -Xmx16m -Xmn6m -XX:SurvivorRatio=2 -XX:-UseAdaptiveSizePolicy

import java.util.List;
import java.util.ArrayList;

package org.example;

public class ThreadsExample {

    static class MyObject1{}
    static class MyObject2{}
    static class MyObject3{}

    public static void main(String... args) {
        int poolSize = 10;

        List<Thread> threads = new ArrayList<Thread>(poolSize);

        Runnable allocateMyObject1 = () -> {
            while(true)
                new MyObject1();
        };

        Runnable allocateMyObject2 = () -> {
            while(true)
                new MyObject2();
        };

        Runnable allocateMyObject3 = () -> {
            while(true)
                new MyObject3();
        };


        for(int i=0; i<poolSize; i++){
            Thread thread = new Thread(){

                @Override
                public void run(){
                    while(true)
                        new MyObject1();
                }
            };

            thread.start();
            threads.add( thread );
        }

    }
}
