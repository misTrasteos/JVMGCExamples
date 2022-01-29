//JAVA_OPTIONS -XX:+UseSerialGC -Xlog:gc*
//JAVA_OPTIONS -Xms16m -Xmx16m -Xmn6m -XX:SurvivorRatio=2 -XX:-UseAdaptiveSizePolicy

package org.example;

import java.util.List;
import java.util.LinkedList;

public class VisualVMExample {

    static class MyObject1{}
    static class MyObject2{}

    public static void main(String... args) throws Exception {

        List<MyObject1> reachable = new LinkedList<MyObject1>();

        while(true){
            Thread.sleep( 1 );

            reachable.add( new MyObject1() );
            new MyObject2();
        }
    }
}
