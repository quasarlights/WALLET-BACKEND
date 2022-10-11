package com.example.wallet.interfaces;


import com.example.wallet.models.ProofOfPayment;
import java.util.ArrayList;

public interface IProofOfPaymentService {

    public ArrayList<ProofOfPayment> getProofOfPayment();
    public void saveProofOfPayment(ProofOfPayment proofOfPayment);
    public void deleteProofOfPayment(Long id);
    public ProofOfPayment findProofOfPayment(Long id);
}
