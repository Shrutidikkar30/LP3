import java.util.*;
class Item{
    int value,weight;
    public Item(int value,int weight){
        this.value=value;
        this.weight=weight;
    }
}
class knapsackFraction{
    public  static double getMaxValue(int capacity,Item[] items){
        Arrays.sort(items, new Comparator<Item>() {
           //Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                // Sort in descending order of value-to-weight ratio
                return Double.compare(r2, r1);
            }
        });
        int currentweight=0;
        int totalvalue=0;
        for(Item it:items){
        if(currentweight+it.weight<=capacity){
            currentweight+=it.weight;
            totalvalue+=it.value;
        }
        else{
            int remainingvalue=capacity-currentweight;
            totalvalue+=it.value*((double)remainingvalue/it.weight);
            break;
        }
        
        }
        return totalvalue;
    }
    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),  // Value = 60, Weight = 10
            new Item(100, 20), // Value = 100, Weight = 20
            new Item(120, 30)  // Value = 120, Weight = 30
        };
        int capacity = 50;

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
        
    }