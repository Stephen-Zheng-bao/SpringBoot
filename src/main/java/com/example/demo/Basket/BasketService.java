package com.example.demo.Basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BasketService {

    @Autowired
    private final BasketRepository BasketRepository;

    public BasketService(BasketRepository basketRepository){
        this.BasketRepository = basketRepository;
    }

	public void getBasket(int userID) {
		// TODO Auto-generated method stub
		
	}

}
