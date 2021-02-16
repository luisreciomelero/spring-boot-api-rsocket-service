package com.example.api.services;

import com.example.api.messages.Message;

public interface IRSocketClient {

    public Message requestResponse(String interaction, String data) throws InterruptedException;
}
