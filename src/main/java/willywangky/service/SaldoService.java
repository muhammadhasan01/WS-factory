package willywangky.service;

import willywangky.repository.ChocolateRepository;
import willywangky.repository.SaldoRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class SaldoService {
    private static final SaldoRepository saldoRepository = new SaldoRepository();

    @WebMethod
    public Long getSaldo(){
        try {
            return saldoRepository.getSaldo();
        } catch (Exception e){
            e.printStackTrace();
            return -1L;
        }
    }

    @WebMethod
    public String setSaldo(Long amount){
        try {
            if (amount > 0) {
                if (saldoRepository.setSaldo(amount) > 0) {
                    return "Success";
                } else {
                    return "Fail";
                }
            } else {
                return "Fail";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }

    @WebMethod
    public String addSaldo(Long amount){
        try {
            if (amount > 0) {
                if (saldoRepository.addSaldo(amount) > 0) {
                    return "Success";
                } else {
                    return "Fail";
                }
            } else {
                return "Fail";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }
}
