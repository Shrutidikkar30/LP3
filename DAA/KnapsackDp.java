import java.util.*;
class KnapsackDp{
	public static int getMaxValue(int values[], int weights[], int capacity){
	int n=values.length;
	int dp[][]=new int[n+1][capacity+1];
	for(int i=0;i<=n;i++){
		for(int w=0;w<=capacity;w++){
			if(i==0 || w==0){
				dp[i][w]=0;
			}
			else if(weights[i-1]<=w){
				dp[i][w]=Math.max(values[i-1]+dp[i-1][w-weights[i-1]],dp[i-1][w]);
			}
			else{
				dp[i][w]=dp[i-1][w];
			}
		}
	}
	return dp[n][capacity];
}
public static void main(String args[]){
    int[] values = {60, 100, 120};   // Values of the items
        int[] weights = {10, 20, 30};    // Weights of the items
        int capacity = 50;               // Capacity of the knapsack

        int maxValue = getMaxValue(values, weights, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
}
}