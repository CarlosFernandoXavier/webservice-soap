package com.example.soapjava11.controller;

import com.example.soapjava11.loaneligibility.Acknowledgement;
import com.example.soapjava11.loaneligibility.CustomerRequest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapController {
    private static final String NAMESPACE = "com/example/soapjava11/loaneligibility";


    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        Integer a = 90;
        return null;
    }
}
