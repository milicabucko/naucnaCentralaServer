package com.sep.naucnacentrala.controller;

import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping(
            value = "/korisnik/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Zdravo", HttpStatus.OK);
    }


    @RequestMapping(
            value = "/korisnik/login/{email:.+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> login(@PathVariable String email) {

        Korisnik k = korisnikService.findByEmail(email);
        Korisnik korisnik = korisnikService.save(k);
        KorisnikService.aktivanKorisnik = korisnik;
        System.out.println("usla sam u kontroler");
        return new ResponseEntity<>(korisnik,HttpStatus.OK);
    }


}
