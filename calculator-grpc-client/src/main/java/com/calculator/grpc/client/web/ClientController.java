package com.calculator.grpc.client.web;
import com.calculator.grpc.client.dto.ClientRequest;
import com.calculator.grpc.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService grpcClientService;

    @PostMapping("/calculate")
    public String printMessage(@RequestBody ClientRequest clientRequest) {
        StringBuilder response = new StringBuilder();
        response.append("calculation for ");
        response.append(clientRequest);
        response.append(" is ");
        response.append(grpcClientService.sendCalculationRequest(clientRequest));

        return response.toString();
    }

}