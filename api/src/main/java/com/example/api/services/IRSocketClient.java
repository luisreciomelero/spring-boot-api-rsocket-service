package com.example.api.services;

import com.example.api.messages.Message;
import com.example.api.models.Employee;

public interface IRSocketClient {

    public Message requestResponse(String interaction, Long data) throws InterruptedException;

    public Message requestResponse(String interaction, Employee employee) throws InterruptedException;

}
