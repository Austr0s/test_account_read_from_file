package test_account.main;

import java.io.File;
import java.util.ArrayList;
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
		List<Account> accounts = readFile();
		List<Account> filteredList = new ArrayList<>();
//		List<Integer> ids = accounts.stream().distinct().map(Account::getId).collect(Collectors.toList());
		accounts.stream().distinct().map(Account::getId).collect(Collectors.toList()).stream().forEach(x -> {
			Account newAccount = new Account();
			newAccount.setId(x);
			newAccount.setBalance(0D);
			accounts.stream().filter(y -> y.getId().equals(x))
					.forEach(z -> newAccount.setBalance(newAccount.getBalance() + z.getBalance()));
			filteredList.add(newAccount);
		});

		filteredList.stream().forEach(System.out::println);
	}

	private static List<Account> readFile() {
		List<Account> accounts = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(".\\accounts.txt"))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line != null && !line.isEmpty()) {
					String[] valueSplit = line.trim().replace(",", ".").split("\\t");
					if (valueSplit.length > 0 && valueSplit[0] != null)
						accounts.add(createAccounts(Integer.valueOf(valueSplit[0]),
								(valueSplit[1] != null) ? Double.valueOf(valueSplit[1]) : Double.valueOf(0)));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return accounts;
	}

	private static Account createAccounts(int id, Double balance) {
		return new Account(id, balance);
	}

}
