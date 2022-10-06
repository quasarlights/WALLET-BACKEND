package com.example.wallet.interfaces;

import com.example.wallet.models.Item;

import java.util.ArrayList;

public interface IitemService {

    public ArrayList<Item> getItem();
    public void saveItem(Item item);
    public void deleteItem(Long id);
    public Item findItem(Long id);

}
