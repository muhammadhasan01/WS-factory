package willywangky.service;

import willywangky.model.Chocolate;
import willywangky.model.Resep;
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

    @WebMethod
    public String addChocolate(Resep chocolateResep){
        System.out.println(chocolateResep);
        try {
            return chocolateRepository.addChocolate(chocolateResep);
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    @WebMethod
    public String produceChocolate(String chocolateName, Long amountToProduce){
        System.out.println(chocolateName);
        try {
            return chocolateRepository.chocolateProduction(chocolateName, amountToProduce);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
