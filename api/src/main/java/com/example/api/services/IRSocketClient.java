package com.example.api.services;

import com.example.api.messages.Message;

public interface IRSocketClient {

    public Message requestResponse() throws InterruptedException;
}
