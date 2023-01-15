
public class MaximumDistanceNearestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] row = {0,1,0,1,0,1,0,1};
		getMaxDist(row);
		
	}

	public static void getMaxDist(int[] rowSeats) {
		int prev_seat = -1;
		int dist = -1;
		for(int i=0;i<rowSeats.length;i++) {
			if(rowSeats[i] == 1) {
				if(prev_seat==-1) {
					dist = i;					
				}
				else {
					dist = Math.max(dist,((i-prev_seat)/2));
				}
				prev_seat = i;
			}
		}
		dist = Math.max(dist, (rowSeats.length-1-prev_seat));
		System.out.println("Maximum distance:: "+dist);
	}
}
