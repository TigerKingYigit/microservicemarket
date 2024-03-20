package com.example.RaporModule.Controller;


import com.example.RaporModule.Models.SaleDTOGet;
import com.example.RaporModule.RaporService.RaporService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
//8085
@RestController
@RequestMapping("raporApi")
public class RaporController {
    @Autowired
    private RaporService raporService;
    /**
     * to get SaleDTOGet object by using rapor service
     * @param  request  send information to pdf dependecy "burayı duzeltecegim"
     * @param sellingNumber which sale we want it to be shown
     * @throws FileNotFoundException it throws exceptions if file not be found
     * */
    @GetMapping("/getsalebynumber/{sellingNumber}")
    public SaleDTOGet getSaleDTOBySellingNumber(HttpServletRequest request, @PathVariable int sellingNumber) throws FileNotFoundException {
        return raporService.getSaleDTOByNumber(sellingNumber,request);
    }
    /**
     * to see detailed sale object on the screen through SaleDTOGet object
     * */
    @GetMapping("/getAllSaleDtoList")
    public List<SaleDTOGet> getAllSaleDtoList(){
        return raporService.getSaleDToListAll();
    }
}
