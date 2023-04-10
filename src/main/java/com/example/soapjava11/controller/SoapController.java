package com.example.soapjava11.controller;

import com.example.soapjava11.loaneligibility.CustomerRequest;
import com.example.soapjava11.mapper.CustomerMapper;
import com.example.soapjava11.model.CustomerModel;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapController {
    private static final String NAMESPACE = "com/example/soapjava11/loaneligibility";

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public void getLoanStatus(@RequestPayload CustomerRequest dto) {
        CustomerModel customerModel = CustomerMapper.toModel(dto);
        Integer a = 90;
        //return null;
    }
}
