package org.globant.GlobantBankLogic;

import org.globant.GlobantBankData.BankDataBase;
import org.globant.GlobantBankData.SavingsAccount;
import org.globant.GlobantBankData.User;

import java.util.List;

public class BankAdminSession {

    private static int attempt = 0;

    private boolean authentication;

    // ------------- CONSTRUCTOR -------------

    public BankAdminSession(){

        this.authentication = false;

    }

    // ----------- GETTERS --------------

    public boolean getAuthentication(){
        return this.authentication;
    }

    public int getAttempt(){
        return attempt;
    }

    // ------------ SETTERS -------------

    public void setAttempt(int reset) {
        attempt = reset;
    }

    public void setAuthentication(int password) {
        if (password == 123){
            this.authentication = true;
            attempt = 0;
        } else {
            attempt++;
        }
    }

    // -------------- METHODS -----------------

    public void createUser(String userName, int password, float balance){
        if (this.authentication){
            User newUser = new User(userName, password, balance);
            BankDataBase.addNewEntry(newUser.getAccount(), newUser);
        }
    }

    public boolean deleteUser(int id){
        return BankDataBase.deleteEntry(id);
    }

    public void listAllUsers(){
        System.out.println("  id  |  User Name  |  Account  |  Creation Date  |  Balance");

        List<SavingsAccount> accounts = BankDataBase.getAllAccounts();
        List<User> users = BankDataBase.getAllUsers();

        for (int i = 0; i < users.size(); i++){
            User currentUser = users.get(i);
            SavingsAccount currentAccount = accounts.get(i);

            System.out.print("  " + currentUser.getId() + "\t\t");
            System.out.print("\t" + currentUser.getUserName() + "\t");
            System.out.print("\t" + currentAccount.getAccountNumber() + "\t");
            System.out.print("\t" + currentAccount.getCreationDate() + "\t");
            System.out.println("\t$" + currentAccount.getBalance() + "  ");
        }
    }
}
