package com.green.greengram.config.enumcode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnumMapper {
    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    //e는 EnumMapperValue를 상속받은 어떤 타입이든 전달 될 수 있다.
    public void put(String key, Class<? extends EnumMapperValue> e){
        factory.put(key, toEnumValues(e));
    }

    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperValue> e) {
        return null;
    }
}
