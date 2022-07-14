package com.europoint.ordering.web.controllers;

import com.europoint.common.service.web.responses.entity.WebBooleanResponse;
import com.europoint.common.service.web.responses.entity.WebListResponseEntity;
import com.europoint.common.service.web.responses.entity.WebPageResponseEntity;
import com.europoint.common.service.web.responses.entity.WebResponseEntity;
import com.europoint.ordering.modules.ordering.api.appservicecontracts.dtos.example.ExampleDto;
import com.europoint.ordering.modules.ordering.api.appservicecontracts.dtos.example.ExampleFiltersDto;
import com.europoint.ordering.modules.ordering.api.appservicecontracts.dtos.example.ExampleType;
import com.europoint.ordering.modules.ordering.api.appservicecontracts.dtos.setting.TerminalResponseDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

//metode delimo na query and commands
//query metode imaju @GetMapping
//query metode primaju uvek parametre kroz RequestParam anotaciju, nikad kroz @PathVariable anotaciju

//command metode imaju @PostMapping
//command metode primaju parametre krzo RequestBody ili RequestParam anotaciju

//command metode prilikom edotvanja ili kreiranja entiteta vracaju to novo stanje, ne samo id ili boolean!
//svi odgovori moraju biti warpovani u jednom od generickih resposneova, koji su(u vreme pisanje ove dokumentacije):
//WebResponseEntity
//WebResponseObject
//WebBooleanResponse
//WebListResponseEntity
//WebPageResponseEntity
//WebStringResponse
//WebUUIDResponse

//obratiti paznju da je mono implementacija samo za ordering,
//ostali kontrolleri optional ilin nesto drugo!

@RestController
@RequestMapping("example")
@Tag(name = "example", description = "Used by ... " +
        "magicValues: body name='pera'; " +
        "mandatory headers " +
        "agentId='3452-ewr234w-werwer234-werwerw'; " +
        "locationId=UUID;")
public class ExampleController {

    public ExampleController() {
    }

    @GetMapping("/getExampleById")
    @CrossOrigin(origins = "*")
    public Mono<WebResponseEntity<ExampleDto>> getExampleById(@RequestParam String id, @RequestHeader Map<String, String> headers) {
        return Mono.just(new WebResponseEntity(new ExampleDto(id)));
    }

    @GetMapping("/getExamplesByType")
    @CrossOrigin(origins = "*")
    public Mono<WebResponseEntity<ExampleDto>> getExamplesByType(@RequestParam ExampleType exampleType, @RequestHeader Map<String, String> headers) {
        return Mono.just(new WebResponseEntity(new ExampleDto()));
    }

    @GetMapping("/getAllExamples")
    @CrossOrigin(origins = "*")
    public Mono<WebListResponseEntity<ExampleDto>> getAllExamples(@RequestHeader Map<String, String> headers) {
        //WEB LIST RESPONSE ENTITY
        return Mono.just(new WebListResponseEntity(new ArrayList<>()));
    }

    @GetMapping("/getExamplesByFilters")
    @CrossOrigin(origins = "*")
    public Mono<WebPageResponseEntity<ExampleDto>> getExamplesByFilters(
            @RequestParam String name,
            @RequestParam ExampleType exampleType,
            @RequestParam boolean active,
            @RequestParam int page,
            @RequestParam int size,
            @RequestHeader Map<String, String> headers) {
        //WEB PAGE RESPONSE ENTITY
        return Mono.just(new WebPageResponseEntity());
    }

    @PostMapping("/createExample")
    @CrossOrigin(origins = "*")
    public Mono<WebResponseEntity<ExampleDto>> createExample(@RequestBody ExampleDto exampleDto, @RequestHeader Map<String, String> headers) {
        //WEB REQUEST ENTITY
        return Mono.just(new WebResponseEntity(exampleDto));
    }

    @PostMapping("/toggleIsExampleActive")
    @CrossOrigin(origins = "*")
    public Mono<WebResponseEntity<ExampleDto>> toggleIsExampleActive(@RequestParam String id, @RequestHeader Map<String, String> headers) {
        //WEB RESPONSE ENTITY
        return Mono.just(new WebResponseEntity(new ExampleDto()));
    }

    @PostMapping("/addExampleToContainer")
    @CrossOrigin(origins = "*")
    public Mono<WebBooleanResponse> addExampleToContainer(@RequestParam String exampleId, @RequestParam String containerId, @RequestHeader Map<String, String> headers) {
        //WEB BOOLEN RESPONSE
        return Mono.just(new WebBooleanResponse(true));
    }

    @PostMapping("/updateExample")
    @CrossOrigin(origins = "*")
    public Mono<WebResponseEntity<ExampleDto>> updateExample(@RequestBody ExampleDto exampleDto, @RequestHeader Map<String, String> headers) {
        //WEB RESPONSE ENTITY
        return Mono.just(new WebResponseEntity(exampleDto));
    }

    @PostMapping("/deleteExampleById")
    @CrossOrigin(origins = "*")
    public Mono<WebBooleanResponse> deleteExampleById(@RequestParam String id, @RequestHeader Map<String, String> headers) {
        //WEB BOOLEAN RESPONSE
        return Mono.just(new WebBooleanResponse(true));
    }
}
