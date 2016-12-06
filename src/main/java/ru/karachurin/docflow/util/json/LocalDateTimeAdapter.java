package ru.karachurin.docflow.util.json;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * Created by Денис on 06.12.2016.
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        return LocalDateTime.parse(s);
    }
    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
        return dateTime.toString();
    }
}