///usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA_OPTIONS -Xint -XX:StartFlightRecording=dumponexit=true,filename=JFRCustomEventsExample.jfr

/**
 * jbang run JFRCustomEventsExample
 * jfr print JFRCustomEventsExample.jfr
 * jfr print --events org.event.CustomEvent JFRCustomEventsExample.jfr
 */

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

public class JFRCustomEventsExample {

	@Name("org.event.CustomEvent")
	@Label("My custom Event")
	static class CustomEvent extends Event {
        @Label("some message")
        String message;
    }
    public static void main(String... args) {

        for(int i=0; i<1_000; i++){
            CustomEvent event = new CustomEvent();

            event.begin();
            event.message = String.valueOf(i);
            event.commit();
        }
    }
}
