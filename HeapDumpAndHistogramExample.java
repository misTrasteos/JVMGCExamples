/// jmap -histo:live $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1) | grep -i Patient
/// jmap -dump:live,format=b,file=heap.hprof $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)

///JAVA_OPTIONS -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
//JAVA_OPTIONS -Xlog:gc*
//JAVA_OPTIONS -Xms32m -Xmx32m

//JAVA_OPTIONS -XX:NewSize=10m -XX:SurvivorRatio=3
//JAVA_OPTIONS -XX:-UseAdaptiveSizePolicy

package org.example;

import java.util.LinkedList;
import java.util.List;

public class HeapDumpAndHistogramExample {

    static class MyObject1{}
    static class MyObject2{}

    public static void main(String... args) throws Exception {
        List<MyObject1> objects1 = new LinkedList<MyObject1>();

        for(int i=0; i< 10_000; i++){
            objects1.add( new MyObject1() );
            new MyObject2();
        }

        Thread.currentThread().join();
    }

}
