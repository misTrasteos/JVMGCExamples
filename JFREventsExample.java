import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

public class JFREventsExample {

	@Name("com.sample.Duration")
	@Label("MyDurationCustomEvent")
	static class DurationEvent extends Event {}

    public static void main(String... args) {

        DurationEvent event = new DurationEvent();

        event.begin();
        
        for(int i=0; i<1_000_000; i++)
            java.time.LocalDateTime.now();

        event.commit();
    }
}

