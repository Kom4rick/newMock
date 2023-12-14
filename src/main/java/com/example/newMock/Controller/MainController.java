package com.example.newMock.Controller;

import com.example.newMock.Model.RequestDTO;
import com.example.newMock.Model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Random;

@RestController
public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);
    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public Object postBalances(@RequestBody RequestDTO requestDTO) {
        try {
            ResponseDTO responseDTO = new ResponseDTO();
            String clientId = requestDTO.getClientId();
            char firstDigit = clientId.charAt(0);
            BigDecimal maxLimit;
            if(firstDigit == '8') {
                responseDTO.setCurrency("US");
                maxLimit = new BigDecimal(2000);
                responseDTO.setBalance(String.valueOf( Math.random() * (maxLimit.intValue()+1)));
                responseDTO.setMaxLimit(maxLimit.toString());
            } else if (firstDigit == '9') {
                responseDTO.setCurrency("EU");
                maxLimit = new BigDecimal(1000);
                responseDTO.setBalance(String.valueOf( Math.random() * (maxLimit.doubleValue()+1)));
                responseDTO.setMaxLimit(maxLimit.toString());
            } else {
                responseDTO.setCurrency("RU");
                maxLimit = new BigDecimal(50000);
                responseDTO.setBalance(String.valueOf(Math.random() * (maxLimit.doubleValue()+1)));
                responseDTO.setMaxLimit(maxLimit.toString());
            }




            responseDTO.setRqUID(requestDTO.getRqUID());
            responseDTO.setClientId(clientId);
            responseDTO.setAccount(requestDTO.getAccount());
//            responseDTO.setCurrency("RU");
//            responseDTO.setBalance(new BigDecimal(777).toString());
//            responseDTO.setMaxLimit(maxLimit.toString());

            log.error("********* RequestDTO *********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDTO));
            log.error("********* RequestDTO *********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDTO));

            return responseDTO;


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
