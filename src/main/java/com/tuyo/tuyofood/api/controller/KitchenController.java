package com.tuyo.tuyofood.api.controller;

import com.tuyo.tuyofood.domain.entity.Kitchen;
import com.tuyo.tuyofood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* GET /kitchens HTTP/1.1
*  1. @Controller: Indica que é uma Classe Component do tipo Controlador
*  2. @RequestMapping: mapear o controlador com uma URI: /kitchens
*  3. @ResponseBody: indica que a resposta dos métodos desse controlador devem ir para
* a resposta da requisição HTTP. Ou seja, a resposta do método listar, deve listar as cozinhas
*  4. @RestController: substitui @Controller e @ResponseBody, cumprindo assim, ambas necessidades
* e indica que é um Controller Rest */

// @Controller
// @ResponseBody
@RestController
@RequestMapping(value = "/kitchens") // , produces = MediaType.APPLICATION_JSON_VALUE)
public class KitchenController {

    /* 1. Variável de instância kitchenRepository
    *  2. Injetar: @Autowired */
    @Autowired
    private KitchenRepository kitchenRepository;

    /* 1. Método retorna uma lista de cozinha
    *  2. @GetMapping: mapear o método
    *  3. @GetMapping: É o mapeamento das requisições com verbo http get que chegarão neste método
    *  4. produces: representa o tipo específico de conteúdo:
    *  a. Métodos específicos:
    *  Com String: @GetMapping (produces = "application/json") ou uma constante: @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    *  Para dois tipos: @GetMapping (produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    *  b. Escopo da classe inteira: passar no parâmetro do @RequestMapping ali em cima. */

    @GetMapping //(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public List<Kitchen> listar() {
        return kitchenRepository.listar();
    }

 /*   Recebendo recursos com métodos diferentes:

 @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Kitchen> listar1() {
        System.out.println("LISTAR 1");
        return kitchenRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Kitchen> listar2() {
        System.out.println("LISTAR 2");
        return kitchenRepository.listar();
    }*/
}
