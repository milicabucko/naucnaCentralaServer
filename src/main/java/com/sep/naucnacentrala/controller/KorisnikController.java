package com.sep.naucnacentrala.controller;

import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.service.KorisnikService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    private static final Logger logger = LoggerFactory.getLogger(KorisnikController.class);

    @RequestMapping(
            value = "/korisnik/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Zdravo", HttpStatus.OK);
    }


    @RequestMapping(
            value = "/korisnik/registration",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> login(@RequestBody Korisnik korisnik) {

        korisnik.setLozinka(BCrypt.hashpw(korisnik.getLozinka(), BCrypt.gensalt()));
        korisnik = korisnikService.save(korisnik);
        logger.info("\n\t\tKorisnik je uspešno registrovan.\n");
        return new ResponseEntity<>(korisnik, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/korisnik/commonPassword/{lozinka}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isCommonPassword(@PathVariable String lozinka) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/sep/naucnacentrala/txtfiles/commonPasswords.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (lozinka.equals(line)) {
                    return new ResponseEntity<>(true, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/korisnik/login/{email:.+}/{lozinka}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> login(@PathVariable String email, @PathVariable String lozinka) {

        Korisnik k = korisnikService.findByEmail(email);
        if (k != null) {
            if (BCrypt.checkpw(lozinka, k.getLozinka())) {
                KorisnikService.aktivanKorisnik = k;
                return new ResponseEntity<>(k, HttpStatus.OK);
            }
        }
        Korisnik nepostojeciKorisnik = new Korisnik();
        nepostojeciKorisnik.setId(-1L);
        return new ResponseEntity<>(nepostojeciKorisnik, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/getActiveUser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Korisnik> getActiveUser() {

        return new ResponseEntity<Korisnik>(korisnikService.aktivanKorisnik, HttpStatus.OK);
    }




}
