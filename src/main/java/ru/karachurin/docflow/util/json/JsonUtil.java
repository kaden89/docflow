package ru.karachurin.docflow.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Created by Денис on 06.12.2016.
 */
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

   public static <T> String toJson(T obj) throws JsonProcessingException {
       ObjectWriter writer = mapper.writer();
       return writer.writeValueAsString(obj);
   }
}
