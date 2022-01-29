///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.quarkus:quarkus-resteasy:2.6.3.Final

//JAVA_OPTIONS -Xint -XX:-UseAdaptiveSizePolicy -XX:+UseSerialGC -Xms256m -Xmx256m

import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/MyObject")
@ApplicationScoped
public class YoungCollectionTunningExample {
  
  private Response response = Response.noContent().build();

  private int OBJECTSTOCREATE = 1_000_000;

  static class MyObject{
    int a = 0;  
  }

  @GET
  public Response getMyObject() {
    for(int i=0; i<OBJECTSTOCREATE; i++)
      new MyObject();

    return response;
  }

}
