/// jbang run JstatExample.java
/// jstat -g $(jps | grep JstatExample | cut -d " " -f1) 1s

//DEPS org.apache.commons:commons-collections4:4.4
//DEPS org.apache.commons:commons-lang3:3.12.0

//JAVA_OPTIONS -XX:+UseSerialGC -Xlog:gc*
//JAVA_OPTIONS -XX:-UseAdaptiveSizePolicy -Xmn12m -Xms32m -Xmx32m -XX:SurvivorRatio=2

package org.example;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.lang3.RandomUtils ;

public class JstatExample {

    public static void main(String... args) throws Exception {

        CircularFifoQueue<byte[]> queue = new CircularFifoQueue<byte[]>(500);

        while(args.length >= 0){
            Thread.sleep( 1 );
 
            queue.add( new byte[RandomUtils.nextInt(0, 10_000)] );
        }
    }
}
