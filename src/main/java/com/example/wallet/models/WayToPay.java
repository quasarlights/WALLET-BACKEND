package com.example.wallet.models;


import javax.persistence.*;

@Entity
@Table(name = "wayToPay")
public class WayToPay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean installments;

    private int installmentsPlan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isInstallments() {
        return installments;
    }

    public void setInstallments(boolean installments) {
        this.installments = installments;
    }

    public int getInstallmentsPlan() {
        return installmentsPlan;
    }

    public void setInstallmentsPlan(int installmentsPlan) {
        this.installmentsPlan = installmentsPlan;
    }
}
