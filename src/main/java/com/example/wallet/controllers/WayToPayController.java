package com.example.wallet.controllers;

import com.example.wallet.models.WayToPay;
import com.example.wallet.services.WayToPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class WayToPayController {

    @Autowired
    WayToPayService wayToPayService;

    //CREATE
    @PostMapping("/waytopay/create")
    public WayToPay createWayToPay(@RequestBody WayToPay wayToPay){
        return wayToPayService.saveWayToPay(wayToPay);

    }

    //READ
    @GetMapping("/waytopay/read")
    public ArrayList<WayToPay> readWayToPay(){
       return wayToPayService.getAllItem();
    }

    //UPDATE
    @PutMapping("/waytopay/update/{id}")
    public ResponseEntity<WayToPay> updateWayToPay(@PathVariable("id") Long id,
                                                    @RequestBody WayToPay newWayToPay){
        WayToPay wayToPay=wayToPayService.findWayToPay(id);
        newWayToPay.setId(wayToPay.getId());

        return new ResponseEntity<>(wayToPayService.saveWayToPay(newWayToPay), HttpStatus.OK);
    }
    /*
      //UPDATE
      @PutMapping("/proofofpayment/update/{id}")
      public ResponseEntity<ProofOfPayment> updateProofOfPayment(@PathVariable("id") Long id,
                                                                  @RequestBody ProofOfPayment newProofOfPayment){
          ProofOfPayment proofOfPayment = proofOfPaymentService.findProofOfPayment(id);
          newProofOfPayment.setId(proofOfPayment.getId());

          return new ResponseEntity<>(proofOfPaymentService.saveProofOfPayment(newProofOfPayment), HttpStatus.OK);
      }*/


    //DELETE
    @DeleteMapping("/waytopay/delete/{id}")
    public String deleteWayToPay(@PathVariable("id") Long id){
        wayToPayService.deleteWayToPay(id);
        return "Way to Pay Deleted";
    }

     /*


    //DELETE
    @DeleteMapping("/proofofpayment/delete/{id}")
    public String deleteProofOfPayment(@PathVariable("id")Long id){
        proofOfPaymentService.deleteProofOfPayment(id);
        return "Proof Of Payment Eliminated";
    }

}

    */

}
