package com.sep.naucnacentrala.controller;

import com.sep.naucnacentrala.dto.IzdanjeMagazinaDTO;
import com.sep.naucnacentrala.dto.MagazinDTO;
import com.sep.naucnacentrala.dto.NaucniRadDTO;
import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.model.Magazin;
import com.sep.naucnacentrala.service.KorisnikService;
import com.sep.naucnacentrala.service.MagazinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MagazinController {


    @Autowired
    private MagazinService magazinService;

    @Autowired
    private KorisnikService korisnikService;

    private final RestTemplate restTemplate;


    @Autowired
    public MagazinController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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
       List<IzdanjeMagazinaDTO> izdanjaMagazina = magazinService.findAllListaIzdanjeMagazina(KorisnikService.aktivanKorisnik.getId(), magazinId);
        System.out.println("Izdanja magazina" + izdanjaMagazina.size());
        return new ResponseEntity<List<IzdanjeMagazinaDTO>>(izdanjaMagazina, HttpStatus.OK);
    }

    @RequestMapping(
            value    = "/izdanje/izlistajSveRadove/{izdanjeId}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<NaucniRadDTO>> izlistajSveRadove(@PathVariable Long izdanjeId) {
        List<NaucniRadDTO> listaRadova = magazinService.findAllListaNaucniRad(KorisnikService.aktivanKorisnik.getId(), izdanjeId);
        System.out.println("IlistaRadova" + listaRadova.size());
        return new ResponseEntity<List<NaucniRadDTO>>(listaRadova, HttpStatus.OK);
    }

    @RequestMapping(
            value    = "/kupovina/{korisnikId}/{proizvodId}/{tipProizvoda}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> kupovina(@PathVariable Long korisnikId, @PathVariable Long proizvodId, @PathVariable String tipProizvoda) {
        System.out.println("Dosao");
        magazinService.kupovina(korisnikId, proizvodId, tipProizvoda);
        //restTemplate.getForObject("http://localhost:4200", null, Void.class);
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    @RequestMapping(
            value    = "/kupovina/{korisnikId}/{proizvodId}/{tipProizvoda}/{brojMeseci}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> kupovinaClanarine(@PathVariable Long korisnikId, @PathVariable Long proizvodId, @PathVariable String tipProizvoda, @PathVariable Integer brojMeseci) {
        System.out.println("Dosao");
        String danasnjiDatum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        magazinService.kupovinaPutemClanarine(korisnikId, proizvodId, brojMeseci, danasnjiDatum, true);
        //restTemplate.getForObject("http://localhost:4200", null, Void.class);
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }


}
