package com.gmontinny.multipleauthapi.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializer extends StdSerializer<LocalDateTime> {

    public CustomDateSerializer() {
        this(LocalDateTime.class);
    }

    public CustomDateSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public void serialize(LocalDateTime localDateTime,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeString(localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

    }
}
