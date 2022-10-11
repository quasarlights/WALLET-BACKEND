package com.example.wallet.repositories;

import com.example.wallet.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    //public List<Item> findAllbyId(Long id);

   /* public abstract ArrayList<Item> findByUser(String user);
    public abstract ArrayList<Item> findByPerson(String person);
    public abstract ArrayList<Item> findByCategory(String category);
    //public abstract ArrayList<Item> findByPeriod(Period period);
    */
    
}
