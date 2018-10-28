package ru.job4j.banking;

import java.util.*;

public class Banking {
    Map<User, List<Account>> users = new HashMap<>();

    /**
     * Add new user.
     *
     * @param user
     */
    public void addUser(User user) {
        users.computeIfAbsent(user, k -> new ArrayList<>());
    }

    /**
     * Delete user.
     *
     * @param user
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    private User findUserByPassport(String passport) {
        return users.keySet().stream().filter(user -> user.getPassport().equals(passport)).findAny().orElse(null);
    }

    /**
     * add account.
     *
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.indexOf(account) == -1) {
            accounts.add(account);
        }
    }

    /**
     * delete account
     *
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.indexOf(account) != -1) {
            accounts.remove(account);
        }
    }

    /**
     * get account
     *
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        return users.get(findUserByPassport(passport));
    }

    private Account findAccountByRequisite(String passport, String requisite) {
        Account result = null;
        List<Account> accounts = users.get(findUserByPassport(passport));
        if (accounts != null) {
            result = accounts.stream().filter(account -> account.getRequisites().equals(requisite)).findFirst().orElse(null);
        }
        return result;
    }

    /**
     * transfer money
     *
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param dstRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findAccountByRequisite(srcPassport, srcRequisite);
        Account destAccount = findAccountByRequisite(destPassport, dstRequisite);
        if (srcAccount != null && destAccount != null && amount <= srcAccount.getValue() && amount > 0) {
            double srcValue = srcAccount.getValue();
            double destValue = destAccount.getValue();
            srcAccount.setValue(srcValue - amount);
            destAccount.setValue(destValue + amount);
            result = true;
        }
        return result;
    }

}