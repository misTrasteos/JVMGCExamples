//DEPS org.apache.commons:commons-collections4:4.4
//DEPS org.apache.commons:commons-lang3:3.12.0

//JAVA_OPTIONS -XX:+UseSerialGC
//JAVA_OPTIONS -Xlog:gc*
//JAVA_OPTIONS -Xms32m -Xmx32m

//JAVA_OPTIONS -Xmn12m -XX:SurvivorRatio=2
//JAVA_OPTIONS -XX:-UseAdaptiveSizePolicy

package org.example;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import java.util.Queue;

import org.apache.commons.lang3.RandomStringUtils;

public class JstatExample {

    public static void main(String... args) throws Exception {

        Queue<String> queue = new CircularFifoQueue<String>(1_000);       

        while(args.length >= 0){
            Thread.sleep( 20 );

            queue.add( RandomStringUtils.randomAlphanumeric( 10_000 ) );
        }
    }
}
