package com.example.wallet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wayToPay_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private WayToPay wayToPay;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proofOfPayment_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProofOfPayment proofOfPayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public WayToPay getWayToPay() {
        return wayToPay;
    }

    public void setWayToPay(WayToPay wayToPay) {
        this.wayToPay = wayToPay;
    }

    public ProofOfPayment getProofOfPayment() {
        return proofOfPayment;
    }

    public void setProofOfPayment(ProofOfPayment proofOfPayment) {
        this.proofOfPayment = proofOfPayment;
    }
}
