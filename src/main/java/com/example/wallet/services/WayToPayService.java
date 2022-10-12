package com.example.wallet.services;

import com.example.wallet.interfaces.IWayToPayService;
import com.example.wallet.models.WayToPay;
import com.example.wallet.repositories.WayToPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WayToPayService implements IWayToPayService {

    @Autowired
    WayToPayRepository wayToPayRepository;

    public ArrayList<WayToPay> getAllItem(){
        return (ArrayList<WayToPay>) wayToPayRepository.findAll();
    }

    public WayToPay save(WayToPay wayToPay){
        return wayToPayRepository.save(wayToPay);
    }


    @Override
    public ArrayList<WayToPay> getWayToPay() {
        ArrayList<WayToPay> wayToPayArrayList= (ArrayList<WayToPay>) wayToPayRepository.findAll();
        return null;
    }

    @Override
    public void saveWayToPay(WayToPay wayToPay) {
    wayToPayRepository.save(wayToPay);
    }

    @Override
    public void deleteWayToPay(Long id) {
    wayToPayRepository.deleteById(id);
    }

    @Override
    public WayToPay findWayToPay(Long id) {
        WayToPay wayToPay = wayToPayRepository.findById(id).orElse(null);
        return null;
    }
}
