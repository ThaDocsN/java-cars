package com.thadocizn.cars;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CarMessage implements Serializable {

    private String msgs;
    private String strDate;

    public CarMessage(@JsonProperty("msgs") String msgs) {
        this.msgs = msgs;

        Date date = new Date();
        String format = "yyyy-MM-dd hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(format);
        strDate = dateFormat.format(date);
    }
}
