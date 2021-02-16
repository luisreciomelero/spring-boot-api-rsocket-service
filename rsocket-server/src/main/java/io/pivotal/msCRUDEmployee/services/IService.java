package io.pivotal.msCRUDEmployee.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IService {


    List<String> doInteraction(String interaction, Object data) throws JsonProcessingException;
}
