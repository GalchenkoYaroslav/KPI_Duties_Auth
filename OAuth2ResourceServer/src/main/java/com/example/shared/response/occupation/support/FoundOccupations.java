package com.example.shared.response.occupation.support;

import java.util.List;
import java.util.Map;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 06.09.2016
 */

public class FoundOccupations {

    private Map<Integer, ItemById> itemsById;

    private List<Integer> itemsList;

    public Map<Integer, ItemById> getItemsById() {
        return itemsById;
    }

    public void setItemsById(Map<Integer, ItemById> itemsById) {
        this.itemsById = itemsById;
    }

    public List<Integer> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Integer> itemsList) {
        this.itemsList = itemsList;
    }
}
