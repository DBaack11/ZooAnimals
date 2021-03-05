import java.util.List;

import controller.ZooKeeperHelper;
import model.ZooKeeper;

/**
 * 
 */

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */
public class ZooTester {

	public static void main(String[] args) {
		ZooKeeper bill = new ZooKeeper("Bill");
		
		ZooKeeperHelper zkh = new ZooKeeperHelper();
		
		zkh.insertZooKeeper(bill);
		
		List<ZooKeeper> allZooKeepers = zkh.showAllZooKeepers();
		
		for(ZooKeeper zk : allZooKeepers) {
			System.out.println(zk.toString());
		}
	}

}
