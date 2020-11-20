package willywangky.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class Hello {
    @WebMethod
    public String HelloWorld(){
        return "Hello, World!";
    }
}
