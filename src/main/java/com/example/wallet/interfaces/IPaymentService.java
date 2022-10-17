package com.example.wallet.interfaces;

import com.example.wallet.models.Payment;
import java.util.ArrayList;

public interface IPaymentService {

    public ArrayList<Payment> getPayment();
    public Payment savePayment(Payment payment);
    public void deletePayment(Long id);
    public Payment findPayment(Long id);
}
