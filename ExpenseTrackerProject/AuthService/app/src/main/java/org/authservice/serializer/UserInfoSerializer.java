package org.authservice.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.common.serialization.Serializer;
import org.authservice.model.UserInfoDTO;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoDTO> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public byte[] serialize(String topic, UserInfoDTO data) {
        byte[] returnValue = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            returnValue = objectMapper.writeValueAsString(topic).getBytes();
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }



    @Override
    public void close() {}
}
