package willywangky.service;

import willywangky.model.Chocolate;
import willywangky.repository.ChocolateRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ChocolateService {
    private static final ChocolateRepository chocolateRepository = new ChocolateRepository();

    @WebMethod
    public List<Chocolate> getAllChcolate(){
        try {
            return chocolateRepository.getAllChocolate();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
