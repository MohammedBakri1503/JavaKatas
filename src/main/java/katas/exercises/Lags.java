
package katas.exercises;


import java.util.ArrayList;
import java.util.List;

public class Lags {

    static class Request {
        String id;
        int startTime;
        int duration;
        int payment;

        public Request(String id, int startTime, int duration, int payment) {
            this.id = id;
            this.startTime = startTime;
            this.duration = duration;
            this.payment = payment;
        }

        public int getEndTime() {
            return startTime + duration;
        }
    }

    /**
     * Finds the maximum profit from a list of delivery requests that do not overlap.
     *
     * @param requests the list of delivery requests, sorted by start time
     * @return the maximum profit
     */
    public static int maximizeProfit(List<Request> requests) {
        int n = requests.size();
        int[] dp = new int[n];

        // Initialize the DP array: base case for the first request
        dp[0] = requests.get(0).payment;

        // Helper function to find the last non-overlapping request using binary search
        for (int i = 1; i < n; i++) {
            // Find the last request that doesn't overlap with the current one
            int prevIndex = binarySearch(requests, i);

            // Calculate the maximum profit for current request i
            if (prevIndex != -1) {
                dp[i] = Math.max(requests.get(i).payment + dp[prevIndex], dp[i - 1]);
            } else {
                dp[i] = Math.max(requests.get(i).payment, dp[i - 1]);
            }
        }

        // The last value in the DP array will be the answer
        return dp[n - 1];
    }

    /**
     * Binary search for the last non-overlapping request.
     */
    private static int binarySearch(List<Request> requests, int index) {
        int low = 0, high = index - 1;
        int targetEndTime = requests.get(index).startTime;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (requests.get(mid).getEndTime() <= targetEndTime) {
                if (requests.get(mid + 1).getEndTime() <= targetEndTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("REQ01", 0, 5, 50));
        requests.add(new Request("REQ02", 3, 7, 80));
        requests.add(new Request("REQ03", 5, 4, 60));
        requests.add(new Request("REQ04", 6, 3, 70));

        int maxProfit = maximizeProfit(requests);

        System.out.println("Maximum Profit: " + maxProfit); // Output: 120
    }
}

