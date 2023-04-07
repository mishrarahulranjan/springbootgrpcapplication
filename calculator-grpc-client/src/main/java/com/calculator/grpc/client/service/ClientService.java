package com.calculator.grpc.client.service;

import com.calculator.grpc.api.CalculationResponse;
import com.calculator.grpc.api.CalculationRequest;
import com.calculator.grpc.client.dto.ClientRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import com.calculator.grpc.api.CalculationServiceGrpc.CalculationServiceBlockingStub;

@Service
public class ClientService {

    @GrpcClient("server")
    CalculationServiceBlockingStub clientStub;

    public long sendCalculationRequest(ClientRequest clientRequest){
        CalculationResponse response = clientStub.calculate(CalculationRequest.newBuilder().setNum1(clientRequest.getNum1()).setNum2(clientRequest.getNum2()).build());
        return response.getNum();
    }
}