package com.goleb.wojciech.dailyDev;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<HasAddress> elementsWithAddress = new ArrayList<>();
        elementsWithAddress.forEach((element)-> {
            System.out.println(element.getAddress());
        });
    }
}
