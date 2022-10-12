package com.example.wallet.services;

import com.example.wallet.interfaces.IPaymentService;
import com.example.wallet.models.Payment;
import com.example.wallet.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public ArrayList<Payment> getAllItem(){
        return (ArrayList<Payment>) paymentRepository.findAll();
    }

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }
    @Override
    public ArrayList<Payment> getPayment() {
        ArrayList<Payment> paymentArrayList= (ArrayList<Payment>) paymentRepository.findAll();
        return paymentArrayList;
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
    paymentRepository.deleteById(id);
    }

    @Override
    public Payment findPayment(Long id) {
        Payment payment= paymentRepository.findById(id).orElse(null);
        return payment;
    }
}
