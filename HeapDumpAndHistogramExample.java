/// jmap -histo $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1) | grep -i MyObject
/// jmap -histo:live $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1) | grep -i MyObject

/// jmap -dump:format=b,file=HeapDumpAndHistogramExample.hprof $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)
/// jmap -dump:live,format=b,file=HeapDumpAndHistogramExample.hprof $(jps | grep HeapDumpAndHistogramExample | cut -d " " -f1)

//JAVA_OPTIONS -XX:+UseSerialGC -Xlog:gc*
//JAVA_OPTIONS -Xms32m -Xmx32m -XX:NewSize=10m -XX:-UseAdaptiveSizePolicy
//JAVA_OPTIONS -Xint

package org.example;

import java.util.LinkedList;
import java.util.List;

public class HeapDumpAndHistogramExample {

    static class MyObject1{}
    static class MyObject2{}

    public static void main(String... args) throws Exception {
        List<MyObject1> reachable = new LinkedList<MyObject1>();

        for(int i=0; i< 10_000; i++){
            reachable.add( new MyObject1() );
            new MyObject2();
        }

        Thread.currentThread().join();
    }

}
