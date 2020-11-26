package willywangky.service;

import willywangky.dto.BahanWithDate;
import willywangky.model.Bahan;
import willywangky.model.Resep;
import willywangky.repository.ResepBahanRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ResepBahanService {
    private static final ResepBahanRepository resepBahanRepository = new ResepBahanRepository();

    @WebMethod
    public List<Bahan> getAllBahan(){
        try {
            return resepBahanRepository.getAllBahan();
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

    @WebMethod
    public List<Resep> getAllResep(){
        try {
            return resepBahanRepository.getAllResep();
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

    @WebMethod
    public String addBahan(List<BahanWithDate> daftarBahan){
        System.out.println(daftarBahan);
        try {
            for (BahanWithDate b: daftarBahan) {
                resepBahanRepository.saveBahan(b);
            }
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
