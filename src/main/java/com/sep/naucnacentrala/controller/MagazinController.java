package com.sep.naucnacentrala.controller;

import com.sep.naucnacentrala.dto.MagazinDTO;
import com.sep.naucnacentrala.model.Magazin;
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

    @RequestMapping(
            value    = "/magazin/findAllMagazin/{korisnikId}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<MagazinDTO>> findAllMagazin(@PathVariable Long korisnikId) {
        List<MagazinDTO> magazini = magazinService.findAllListaMagazina(korisnikId);
        System.out.println("Magazini" + magazini.size());
        return new ResponseEntity<List<MagazinDTO>>(magazini, HttpStatus.OK);
    }



}
