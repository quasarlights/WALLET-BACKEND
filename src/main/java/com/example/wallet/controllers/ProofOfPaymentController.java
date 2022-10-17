package com.example.wallet.controllers;

import com.example.wallet.models.ProofOfPayment;
import com.example.wallet.services.ProofOfPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ProofOfPaymentController {

    @Autowired
    ProofOfPaymentService proofOfPaymentService;

    //CREATE
    @PostMapping("/proofofpayment/create")
    public ProofOfPayment createProofOfPayment(@RequestBody ProofOfPayment proofOfPayment){
        return proofOfPaymentService.saveProofOfPayment(proofOfPayment);
    }

    //READ
    @GetMapping("/proofofpayment/read")
    public ArrayList<ProofOfPayment> readProofOfPayment(){
        return proofOfPaymentService.getAllItem();
    }

    //UPDATE
    @PutMapping("/proofofpayment/update/{id}")
    public ResponseEntity<ProofOfPayment> updateProofOfPayment(@PathVariable("id") Long id,
                                                                @RequestBody ProofOfPayment newProofOfPayment){
        ProofOfPayment proofOfPayment = proofOfPaymentService.findProofOfPayment(id);
        newProofOfPayment.setId(proofOfPayment.getId());

        return new ResponseEntity<>(proofOfPaymentService.saveProofOfPayment(newProofOfPayment), HttpStatus.OK);
    }


    //DELETE
    @DeleteMapping("/proofofpayment/delete/{id}")
    public String deleteProofOfPayment(@PathVariable("id")Long id){
        proofOfPaymentService.deleteProofOfPayment(id);
        return "Proof Of Payment Eliminated";
    }

}
