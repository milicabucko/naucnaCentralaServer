package com.sep.naucnacentrala.controller;

import com.sep.naucnacentrala.dto.ServerDTO;
import com.sep.naucnacentrala.util.NCUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class UtilController {

    @RequestMapping(
            value = "/util/paymentConcentratorServer",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ServerDTO> paymentConcentratorServer() {
        ServerDTO serverDTO = new ServerDTO(NCUtil.paymentConcentratorAvailable());
        return new ResponseEntity<>(serverDTO, HttpStatus.OK);
    }

}
