package com.luisguzman.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ApplicationContext applicationContext;

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, String... mapperQualifier) {
        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return source
                .stream()
                .map(element->modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <K, S, T> Map<K, List<T>> mapMap(Map<K, List<S>> sourceMap, Class<T> targetClass, String... mapperQualifier) {
        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return sourceMap.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Mantiene la clave
                        entry -> entry.getValue()
                                .stream()
                                .map(element -> modelMapper.map(element, targetClass)) // Mapea cada elemento de la lista
                                .collect(Collectors.toList()) // Recoge en una lista
                ));
    }

    public <S, T> T map(S source, Class<T> targetClass, String... mapperQualifier) {
        ModelMapper modelMapper = getModelMapper(mapperQualifier);
        return modelMapper.map(source, targetClass);
    }

    private ModelMapper getModelMapper(String... mapperQualifier){
        if(mapperQualifier.length == 0 || mapperQualifier[0] == null || mapperQualifier[0].isEmpty()){
            return applicationContext.getBean("defaultMapper", ModelMapper.class);
        }else{
            return applicationContext.getBean(mapperQualifier[0], ModelMapper.class);
        }
    }
}
