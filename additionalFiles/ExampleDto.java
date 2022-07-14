package com.europoint.ordering.modules.ordering.api.appservicecontracts.dtos.example;

import com.europoint.common.service.error.handler.exceptions.BusinessLogicException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;



@Getter
@Setter
public class ExampleDto {

    private String id;
    private String name;
    private boolean active;
    private ExampleType exampleType;

    public ExampleDto() {
        this.id = "asd";
        this.name = "535";
    }
    public ExampleDto(String id) {
        //code i details should be optional ?
        if (id.equals("1")) throw new BusinessLogicException(0, "Id must not be 1", "");
        if (id.equals("2")) throw new IllegalArgumentException("Id must not be 2");
        if (id.equals("3")) throw new NullPointerException("Id must not be 3");

        this.id = "asd";
        this.name = "name123";
    }
}
