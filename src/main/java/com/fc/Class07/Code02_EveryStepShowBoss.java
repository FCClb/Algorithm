package Class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: FC.Clb
 * @Date: 2025/2/2 - 02 - 02 - 11:58
 * @Description: Class07
 * @version: 1.0
 */
public class Code02_EveryStepShowBoss {
    public static class Customer {
        public int id;
        public int buy;
        public int enterTime;

        public Customer(int id, int buy, int enterTime) {
            this.id = id;
            this.buy = buy;
            this.enterTime = 0;
        }
    }

    public static class CandidateComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.buy != c2.buy ? (c2.buy - c1.buy) : (c1.enterTime - c2.enterTime);
        }
    }

    public static class DaddyComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.buy != c2.buy ? (c1.buy - c2.buy) : (c1.enterTime - c2.enterTime);
        }
    }

    public static class WhosYourDaddy {
        private HashMap<Integer,Customer> customers;
        private HeapGreater<Customer> candHeap;
        private HeapGreater<Customer> daddyHeap;
        private final int daddyLimit;

        public WhosYourDaddy(int daddyLimit) {
            this.customers = new HashMap<Integer, Customer>();
            this.candHeap = new HeapGreater<>(new CandidateComparator());
            this.daddyHeap = new HeapGreater<>(new DaddyComparator());
            this.daddyLimit = daddyLimit;
        }

        //当前处理i号事件，arr[i] -> id , buy or refund
        public void operate(int time, int id, boolean buyOrRefund) {
            if (!buyOrRefund && !customers.containsKey(id)) {
                return;
            }
            if (!customers.containsKey(id)) {
                customers.put(id, new Customer(id, 0, 0));
            }
            Customer c = customers.get(id);
            if (buyOrRefund) {
                c.buy++;
            } else {
                c.buy--;
            }
            if (c.buy == 0) {
                customers.remove(id);
            }
            if (!candHeap.contains(c) && !daddyHeap.contains(c)) {
                if (daddyHeap.size() < daddyLimit) {
                    c.enterTime = time;
                    daddyHeap.push(c);
                } else {
                    c.enterTime = time;
                    candHeap.push(c);
                }
            } else if (candHeap.contains(c)) {
                if (c.buy == 0) {
                    candHeap.remove(c);
                } else {
                    candHeap.resign(c);
                }
            } else {//daddyHeap.contains(c)
                if (c.buy == 0) {
                    daddyHeap.remove(c);
                } else {
                    daddyHeap.resign(c);
                }
            }
            daddyMove(time);
        }

        public List<Integer> getDaddies() {
            List<Customer> customers = daddyHeap.getAllElements();
            List<Integer> ans = new ArrayList<>();
            for (Customer customer : customers) {
                ans.add(customer.id);
            }
            return ans;
        }

        private void daddyMove(int time) {
            if (candHeap.isEmpty()) {
                return;
            }
            if (daddyHeap.size() < daddyLimit) {
                Customer p = candHeap.pop();
                p.enterTime = time;
                daddyHeap.push(p);
            } else {
                if (candHeap.peek().buy > daddyHeap.peek().buy) {
                    Customer oldDaddy = daddyHeap.pop();
                    Customer newDaddy = candHeap.pop();
                    oldDaddy.enterTime = time;
                    newDaddy.enterTime = time;
                    daddyHeap.push(newDaddy);
                    candHeap.push(oldDaddy);
                }
            }
        }
    }

    public static List<List<Integer>> topK(int[] arr, boolean[] op, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        WhosYourDaddy whosYourDaddy = new WhosYourDaddy(k);
        for (int i = 0; i < arr.length; i++) {
            whosYourDaddy.operate(i, arr[i], op[i]);
            ans.add(whosYourDaddy.getDaddies());
        }
        return ans;
    }
}
