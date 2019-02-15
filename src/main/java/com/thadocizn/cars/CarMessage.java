package com.thadocizn.cars;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarMessage implements Serializable {

    private String msgs;
    private String date;

    public CarMessage(@JsonProperty("msgs") String msgs,
                      @JsonProperty("date") String date) {
        this.msgs = msgs;
        this.date = date;
    }
}
