package com.example.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component //siempre poner esto en elementos del util o se rompe tuto el proyecto
public class MapperUtil {
    // macunfla de la clase oasdkadsk asdasd asdasd

    private static ObjectMapper mapper = new ObjectMapper();


    private MapperUtil() {
    }
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {

        return source
                .stream()
                .map(element -> mapper.convertValue(element, targetClass))
                .collect(Collectors.toList());
    }
}
