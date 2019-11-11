/*
package ar.edu.ucc.arqsoft.test.utils;

import org.springframework.web.client.RestTemplate;

import ar.edu.ucc.arqsoft.test.dto.RequestAutorizacionDto;
import ar.edu.ucc.arqsoft.test.dto.ResponseAutorizacionDto;
import ar.edu.ucc.arqsoft.test.dto.TarjetaDto;

public class AutorizacionUtils {


    public static void main(String[] args) {
        final String uri = "https://iua-service.herokuapp.com/autorizar";

        TarjetaDto tarjetaDto = new TarjetaDto();
        tarjetaDto.setNumero("4");

        RequestAutorizacionDto dto = new RequestAutorizacionDto();

        dto.setTarjeta(tarjetaDto);
        dto.setMonto(31.4);

        RestTemplate restTemplate = new RestTemplate();
        ResponseAutorizacionDto result = restTemplate.postForObject( uri, dto, ResponseAutorizacionDto.class);

        System.out.println(result.toString());

    }

}

 */