package willywangky;

import willywangky.repository.UserRepository;
import willywangky.service.Hello;
import willywangky.service.LoginService;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/api/hello", new Hello());
        Endpoint.publish("http://localhost:8081/api/login", new LoginService());


        // test
//        if (new UserRepository().isUserExist("ww", "ww")){
//            System.out.println("Username exist");
//        } else {
//            System.out.println("Username not exist");
//        }
    }
}
