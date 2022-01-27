///usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA_OPTIONS -XX:+UseSerialGC -Xlog:gc*
//JAVA_OPTIONS -Xmn2m -Xms32m -Xmx32m -XX:-UseAdaptiveSizePolicy
//JAVA_OPTIONS -Xint

public class BigObjectExample {
    public static void main(String... args) throws Exception {

        while (args.length > -1){
            Thread.sleep( 2_000 );

            byte[] bytes = new byte[3 * 1024 * 1024];
        }
    }
}
