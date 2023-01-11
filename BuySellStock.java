import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ou are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve 
 * any profit, return 0.
 */

public class BuySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxProfit = 0;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String ip = null;
			while((ip=br.readLine())!= null) {
				String[] ipPrices = ip.split(",");
				int[] prices = new int[ipPrices.length];
				
				for(int i=0;i<ipPrices.length;i++) {
					prices[i] = Integer.parseInt(ipPrices[i]);					
				}
				int j=0;
				int k=j+1;
				while(k<prices.length) {
					if(prices[j] < prices[k]) {
						maxProfit = Math.max(maxProfit, prices[k]-prices[j]);							
					}
					else
						j=k;
					k++;
				}				
				System.out.println("Maximum Profit:: "+maxProfit);
			}
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
