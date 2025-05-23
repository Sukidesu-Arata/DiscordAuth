package com.denisindenbom.discordauth.managers;

import com.denisindenbom.discordauth.units.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountAuthManager
{
    private final List<Account> authenticatedAccounts = new ArrayList<>();

    public AccountAuthManager()
    {}

    public void addAccount(Account account)
    {
        synchronized (this.authenticatedAccounts)
        {this.authenticatedAccounts.add(account);}
    }

    public void removeAccountByName(String name)
    {
        synchronized (this.authenticatedAccounts)
        {
            for (Account account : this.authenticatedAccounts)
            {
                if (account.getName().equals(name))
                {
                    this.authenticatedAccounts.remove(account);
                    break;
                }
            }
        }
    }

    public boolean accountExists(String name)
    {
        return true; // Coi tất cả người chơi là đã xác thực
    }
}
