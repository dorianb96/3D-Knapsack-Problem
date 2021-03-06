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
        items.add(item10);
        items.add(item3);
        items.add(item8);
        items.add(item4);
        items.add(item6);
        items.add(item9);
        items.add(item1);
        items.add(item5);
        items.add(item2);
        items.add(item7);


    }
    public ArrayList<Item> getItems(){
        return greedySpaceSort(items);
    }
    public ArrayList<Item> getGreedyItems(){
        return greedyValueSort(items);
    }
    public ArrayList<Item> getRandomItems(){
        return items;
    }


    /**
     * when multiplying the compareTo() method with -1
     * you get a sorted list with first largest elements
     * and then smaller depending on your criteria
     */
    class ValuePerSpaceCompare implements Comparator<Item>{
        public int compare(Item one, Item two){
            return Double.compare(one.getValue()/one.getVolume(),two.getValue()/two.getVolume());
        }
    }

    class SpaceCompare implements Comparator<Item>{
        public int compare(Item one, Item two){
            return Double.compare(one.getVolume(),two.getVolume());
        }
    }

    public ArrayList<Item> greedyValueSort (ArrayList<Item> items){
        Collections.sort(items,new ValuePerSpaceCompare());
        return items;
    }
    public ArrayList<Item> greedySpaceSort (ArrayList<Item> items){
        Collections.sort(items,new SpaceCompare());
        return items;
    }

    private ArrayList<Item> items;
}
