package com.example.wallet.repositories;

import com.example.wallet.models.WayToPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayToPayRepository extends JpaRepository<WayToPay, Long> {
}
