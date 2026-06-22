//Problem 121. Best Time to Buy and Sell Stock
//problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class BuySell {
    public int maxProfit(int prices[]){
        int n=prices.length;
        int i,cprof,maxprof,min;
        maxprof=0;
        min=prices[0];
        for(i=1;i<n;i++)
        {
         cprof=prices[i]-min;
         if(cprof>maxprof)
           maxprof=cprof;
         if(min>prices[i])
           min=prices[i];
        }
        return maxprof;
    }
    public static void main(String args[]){
        BuySell bs=new BuySell();
        int prices[]={7,1,5,3,6,4};
        System.out.println(bs.maxProfit(prices));
    }
}