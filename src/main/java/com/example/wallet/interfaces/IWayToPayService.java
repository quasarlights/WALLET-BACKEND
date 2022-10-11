package com.example.wallet.interfaces;

import com.example.wallet.models.WayToPay;
import java.util.ArrayList;

public interface IWayToPayService {

    public ArrayList<WayToPay> getWayToPay();
    public void saveWayToPay(WayToPay wayToPay);
    public void deleteWayToPay(Long id);
    public WayToPay findWayToPay(Long id);
}
