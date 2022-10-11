package com.example.wallet.interfaces;

import com.example.wallet.models.Period;
import java.util.ArrayList;

public interface IPeriodService {

    public ArrayList<Period> getPeriod();
    public void savePeriod(Period period);
    public void deletePeriod(Long id);
    public Period findPeriod(Long id);
}
