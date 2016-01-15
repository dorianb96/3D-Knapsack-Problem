package part1ab;

import part1ab.Item;

import java.util.*;

public class Items extends ArrayList{
    public Items(){
        /* here we initialize the three items with their all
        rotations representing a special item */
        // item 1
        Item item1 = new Item(3.01,4,2,2,3);
        Item item2 = new Item(3.02,2,4,2,3);
        Item item3 = new Item(3.03,2,2,4,3);

        // item 3
        Item item4 = new Item(5.01,3,3,3,5);

        // item 2
        Item item5 = new Item(4.02,2,4,3,4);
        Item item6 = new Item(4.03,3,2,4,4);
        Item item7 = new Item(4.04,3,4,2,4);
        Item item8 = new Item(4.05,4,2,3,4);
        Item item9 = new Item(4.06,4,3,2,4);
        Item item10 = new Item(4.01,2,3,4,4);



        /** initialize a new arrayList which holds all items.
         part1ab.Items will be mainly used for accessing so an ArrayList
         is the fastest option */

        items = new ArrayList<Item>(10);
        items.add(item1); items.add(item2);
        items.add(item3); items.add(item4);
        items.add(item5); items.add(item6);
        items.add(item7); items.add(item8);
        items.add(item9); items.add(item10);

    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public ArrayList<Item> getGreedyItems(){
        ArrayList<Item> greedyItems = new ArrayList<Item>(10);
        greedyItems = greedySort(items);
        return greedyItems;
    }
    /*
    this is just a bubble sort but the data set is only 10 items,
    the worst case scenario would be 100 iterations which is nothing
     */
    public ArrayList<Item> greedySort(ArrayList<Item> items){
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < items.size(); i++) {
                Item item1 = items.get(i - 1);
                Item item2 = items.get(i);
                if (item1.getValue() / item1.getVolume() < item2.getValue() / item2.getVolume()) {
                    items.set(i - 1, item2);
                    items.set(i, item1);
                    flag = true;
                }
            }
        }
        return items;
    }
    private ArrayList<Item> items;
}
