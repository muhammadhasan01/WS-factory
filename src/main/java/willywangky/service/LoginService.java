package willywangky.service;

import willywangky.repository.UserRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class LoginService {
    private static final UserRepository userRepository = new UserRepository();
    @WebMethod
    public Boolean isUserExist(String username, String password){
        return userRepository.isUserExist(username, password);
    }

    @WebMethod
    public String cek(){
        return "cek";
    }
}
