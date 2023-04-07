package com.calculator.grpc.server.service;

import com.calculator.grpc.api.CalculationRequest;
import com.calculator.grpc.api.CalculationResponse;
import com.calculator.grpc.api.CalculationServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CalculationGrpcService extends CalculationServiceGrpc.CalculationServiceImplBase {

    @Override
    public void calculate(CalculationRequest req, StreamObserver<CalculationResponse> responseObserver) {
        CalculationResponse reply = CalculationResponse.newBuilder().setNum(req.getNum1()+ req.getNum2()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
