package com.sep.naucnacentrala.controller;

import com.sep.naucnacentrala.dto.IzdanjeMagazinaDTO;
import com.sep.naucnacentrala.dto.MagazinDTO;
import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.model.Magazin;
import com.sep.naucnacentrala.service.KorisnikService;
import com.sep.naucnacentrala.service.MagazinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MagazinController {


    @Autowired
    private MagazinService magazinService;

    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping(
            value    = "/magazin/findAllMagazin",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<MagazinDTO>> findAllMagazin() {
        List<MagazinDTO> magazini = magazinService.findAllListaMagazina(KorisnikService.aktivanKorisnik.getId());
        System.out.println("Magazini" + magazini.size());
        return new ResponseEntity<List<MagazinDTO>>(magazini, HttpStatus.OK);
    }

    @RequestMapping(
            value    = "/magazin/izlistajSvaIzdanja/{magazinId}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<IzdanjeMagazinaDTO>> findAllIzdanjeMagazina(@PathVariable Long magazinId) {
       List<IzdanjeMagazinaDTO> izdanjaMagazina = magazinService.findAllListaIzdanjeMagazina(magazinId, KorisnikService.aktivanKorisnik.getId());
        System.out.println("Izdanja magazina" + izdanjaMagazina.size());
        return new ResponseEntity<List<IzdanjeMagazinaDTO>>(izdanjaMagazina, HttpStatus.OK);
    }

}
