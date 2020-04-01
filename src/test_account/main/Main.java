package test_account.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import test_account.main.model.Account;

/**
 *  
 * @author Austr0s
 *
 */
public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(new File(".\\accounts.txt"))) {
			HashMap<Integer, Double> accounts = new HashMap<>();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line != null && !line.isEmpty()) {
					String[] valueSplit = line.trim().replace(",", ".").split("\\t");
					if (valueSplit[0] != null && valueSplit.length > 0) {
						if (!accounts.containsKey(Integer.valueOf(valueSplit[0])))
							accounts.put(Integer.valueOf(valueSplit[0]), validateAndReturnBalance(valueSplit));
						else
							accounts.merge(Integer.valueOf(valueSplit[0]), validateAndReturnBalance(valueSplit),
									Double::sum);
					}
				}
			}

			accounts.entrySet().stream().forEach(System.out::println);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static double validateAndReturnBalance(String[] valueSplit) {
		return valueSplit.length < 2 ? 0D : Double.valueOf(valueSplit[1]);
	}

}
