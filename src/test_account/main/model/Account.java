package test_account.main.model;

import java.util.Objects;

/**
 *  
 * @author Austr0s
 *
 */
public class Account {

	private Integer id;

	private Double balance;

	public Account() {
	}
	
	public Account(Integer id) {
		this.id = id;
	}

	public Account(Integer id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	@Override
	public String toString() {
		return String.format("[Id: %s, Balance: %s]", String.valueOf(this.id), String.valueOf(this.balance));
	}

}
