package ru.job4j.banking;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class BankingTest {
    @Test
    public void whenAddNewUserThenContainsInUsers() {
        Banking banking = new Banking();
        User user1 = new User("Ivanov Ivan", "123");
        banking.addUser(user1);
        boolean result = banking.users.containsKey(user1);
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUsersThenNotContainsInUsers() {
        Banking banking = new Banking();
        User user1 = new User("Ivanov Ivan", "123");
        User user2 = new User("Petrov Petr", "456");
        banking.addUser(user1);
        banking.addUser(user2);
        banking.deleteUser(user2);
        boolean result = banking.users.containsKey(user2);
        assertThat(result, is(false));
    }

    @Test
    public void whenAddAccountToUserThen() {
        Banking banking = new Banking();
        User user1 = new User("Ivanov Ivan", "123");
        banking.addUser(user1);
        Account account1 = new Account(100, "11111");
        Account account2 = new Account(200, "22222");
        banking.addAccountToUser("123", account1);
        banking.addAccountToUser("123", account2);
        List<Account> result = banking.users.get(user1);
        for (Account a : result) {
            System.out.println(a.getRequisites());
        }
        assertThat(result.get(1).getRequisites(), is("22222"));
    }


    @Test
    public void whenDeleteAccountToUserThen() {
        Banking banking = new Banking();
        User user1 = new User("Ivanov Ivan", "123");
        banking.addUser(user1);
        Account account1 = new Account(100, "11111");
        Account account2 = new Account(200, "22222");
        banking.addAccountToUser("123", account1);
        banking.addAccountToUser("123", account2);
        banking.deleteAccountFromUser("123", account1);
        int result = banking.users.get(user1).indexOf(account1);
        assertThat(result, is(-1));
    }


    @Test
    public void whenTransfer100Then300() {
        Banking banking = new Banking();
        User user1 = new User("Ivanov Ivan", "1");
        User user2 = new User("Petrov Petr", "2");
        banking.addUser(user1);
        banking.addUser(user2);
        Account account1 = new Account(100, "11111");
        Account account2 = new Account(200, "22222");
        banking.addAccountToUser("1", account1);
        banking.addAccountToUser("2", account2);
        banking.transferMoney("1", "11111", "2", "22222", 100);
        double result = banking.users.get(user2).get(0).getValue();
        assertThat(result, closeTo(300.0, 0.01));
    }

    @Test
    public void whenTransferMoneyToNotValidAccountThenFalse() {
        Banking banking = new Banking();
        User user1 = new User("Ivanov Ivan", "1");
        User user2 = new User("Petrov Petr", "2");
        banking.addUser(user1);
        banking.addUser(user2);
        Account account1 = new Account(100, "11111");
        Account account2 = new Account(200, "22222");
        banking.addAccountToUser("1", account1);
        banking.addAccountToUser("2", account2);
        boolean result = banking.transferMoney("1", "11111", "3", "22222", 100);
        assertThat(result, is(false));
    }

}