package com.example.wallet.repositories;

import com.example.wallet.models.ProofOfPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProofOfPaymentRepository extends JpaRepository<ProofOfPayment, Long> {
}
