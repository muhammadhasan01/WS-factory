package willywangky.service;

import willywangky.repository.ChocolateRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ChocolateService {
    private static final ChocolateRepository chocolateRepository = new ChocolateRepository();

    @WebMethod
    public Long addStock(String name, Long amount){
        long res;
        if (chocolateRepository.isChocolateExist(name) | amount < 0){
            res = -1L;
        } else {
            // add chocolate
            res = 2L;
        }
        return res;
    }
}
