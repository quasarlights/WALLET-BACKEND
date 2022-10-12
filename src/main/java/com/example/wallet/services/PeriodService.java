package com.example.wallet.services;

import com.example.wallet.interfaces.IPeriodService;
import com.example.wallet.models.Period;
import com.example.wallet.repositories.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PeriodService implements IPeriodService {
    @Autowired
    PeriodRepository periodRepository;

    public ArrayList<Period> getAllItem(){
        return (ArrayList<Period>) periodRepository.findAll();
    }

    public Period save(Period period){
        return periodRepository.save(period);
    }


    @Override
    public ArrayList<Period> getPeriod() {
        ArrayList<Period> periodArrayList= (ArrayList<Period>) periodRepository.findAll();
        return periodArrayList;
    }

    @Override
    public void savePeriod(Period period) {
    periodRepository.save(period);
    }

    @Override
    public void deletePeriod(Long id) {
    periodRepository.deleteById(id);
    }

    @Override
    public Period findPeriod(Long id) {
        Period period= periodRepository.findById(id).orElse(null);
        return null;
    }
}
