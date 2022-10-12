package com.example.wallet.services;

import com.example.wallet.interfaces.IProofOfPaymentService;
import com.example.wallet.models.ProofOfPayment;
import com.example.wallet.repositories.ProofOfPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProofOfPaymentService implements IProofOfPaymentService {
    @Autowired
    ProofOfPaymentRepository proofOfPaymentRepository;

    public ArrayList<ProofOfPayment> getAllItem(){
        return (ArrayList<ProofOfPayment>) proofOfPaymentRepository.findAll();
    }

    public ProofOfPayment save(ProofOfPayment proofOfPayment){
        return proofOfPaymentRepository.save(proofOfPayment);
    }

    @Override
    public ArrayList<ProofOfPayment> getProofOfPayment() {
        ArrayList<ProofOfPayment> proofOfPaymentArrayList= (ArrayList<ProofOfPayment>) proofOfPaymentRepository.findAll();
        return null;
    }

    @Override
    public void saveProofOfPayment(ProofOfPayment proofOfPayment) {
    proofOfPaymentRepository.save(proofOfPayment);
    }

    @Override
    public void deleteProofOfPayment(Long id) {
    proofOfPaymentRepository.deleteById(id);
    }

    @Override
    public ProofOfPayment findProofOfPayment(Long id) {
        ProofOfPayment proofOfPayment = proofOfPaymentRepository.findById(id).orElse(null);
        return proofOfPayment;
    }
}
