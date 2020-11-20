package willywangky;

import willywangky.service.Hello;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/api/hello", new Hello());
    }
}
