package willywangky.service;

import willywangky.model.RequestAddStock;
import willywangky.repository.ChocolateRepository;
import willywangky.repository.StockRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class StockService {
    private static final StockRepository stockRepository = new StockRepository();
    private static final ChocolateRepository chocolateRepository = new ChocolateRepository();

    @WebMethod
    // add stock , return value adalah id hasil add stock (untuk cek status pending atau tiddak)
    // kalau gagal, return -1 (coklat tidak ada pada daftar)
    public Long addStock(String name, Long amount){
        if (!chocolateRepository.isChocolateExist(name) || amount < 0){
            return -1L;
        } else {
            // add chocolate
            return stockRepository.addStock(name, amount);
        }
    }

    @WebMethod
    // merubah status dari PENDING -> APPROVED jika stock coklat tersedia
    public String approveAddStock(Long id_stock){
        try {
            return stockRepository.approveStock(id_stock);
        } catch (Exception e) {
            e.printStackTrace();
            return "Gagal Approve";
        }
    }

    @WebMethod
    public List<RequestAddStock> getAllReqAddStock(){
        System.out.println("Masuk ke getAllreq");
        try {
            return stockRepository.getAllReqAddStock();
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

    @WebMethod
    public String checkStatus(Long idReqAddStock){
        try {
            return stockRepository.checkStatus(idReqAddStock);
        } catch (Exception e){
            e.printStackTrace();
            return "FAIL";
        }
    }
}
