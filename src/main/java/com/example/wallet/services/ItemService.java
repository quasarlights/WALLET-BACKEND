package com.example.wallet.services;

import com.example.wallet.interfaces.IitemService;
import com.example.wallet.models.Item;
import com.example.wallet.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ItemService implements IitemService {

    @Autowired
    ItemRepository itemRepository;

    public ArrayList<Item> getAllItem(){
        return (ArrayList<Item>) itemRepository.findAll();
    }

  public Item save(Item item){
        return itemRepository.save(item);
  }

    @Override
    public ArrayList<Item> getItem() {
        ArrayList<Item> itemArrayList= (ArrayList<Item>) itemRepository.findAll();
        return itemArrayList;
    }

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);

    }

    @Override
    public Item findItem(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        return item;
    }

}
