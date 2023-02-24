package com.example.demo.Basket;


import com.example.demo.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Products.ProductRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BasketService {

    @Autowired
    private final BasketRepository basketRepository;
    private final ProductRepository productReposiory;
    public BasketService(BasketRepository basketRepository, ProductRepository productReposiory){
        this.basketRepository = basketRepository;
        this.productReposiory = productReposiory;
    }

	public ArrayList<basketItem> getBasket(Integer userID) {
		// TODO Auto-generated method stub
        List<Basket> userBasket = basketRepository.findByuserID(userID.toString());
        ArrayList<basketItem> currentBasket = new ArrayList<basketItem>();

        for (Basket item: userBasket){
            currentBasket.add(new basketItem(productReposiory.findByProductID(item.getProductID().toString()),item.getQuantity()));
        }
        return currentBasket;

	}

    public void createBasket(Basket itemAdd) {
        basketRepository.save(itemAdd);
    }
}
