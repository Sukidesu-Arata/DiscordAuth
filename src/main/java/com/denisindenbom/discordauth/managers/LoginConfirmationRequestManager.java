package com.denisindenbom.discordauth.managers;

import com.denisindenbom.discordauth.managers.LoginConfirmationRequestManager.1;
import com.denisindenbom.discordauth.units.Account;
import com.denisindenbom.discordauth.units.LoginConfirmationRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class LoginConfirmationRequestManager {
   private final List<LoginConfirmationRequest> requests = new ArrayList();
   private final long lifeTimeOfRequest;

   public LoginConfirmationRequestManager(long lifeTimeOfRequest) {
      this.lifeTimeOfRequest = lifeTimeOfRequest;
   }

   public void registerRequest(LoginConfirmationRequest confirmation) {
      synchronized(this.requests) {
         this.requests.add(confirmation);
      }

      (new Timer()).schedule(new 1(this, confirmation), this.lifeTimeOfRequest * 1000L);
   }

   public void removeRequest(String id) {
      synchronized(this.requests) {
         Iterator var3 = this.requests.iterator();

         while(var3.hasNext()) {
            LoginConfirmationRequest loginConfirmationRequest = (LoginConfirmationRequest)var3.next();
            if (loginConfirmationRequest.getId().equals(id)) {
               this.requests.remove(loginConfirmationRequest);
               break;
            }
         }

      }
   }

   public boolean accountHasRequest(Account account) {
      synchronized(this.requests) {
         Iterator var3 = this.requests.iterator();

         LoginConfirmationRequest request;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            request = (LoginConfirmationRequest)var3.next();
         } while(!request.getAccount().getName().equals(account.getName()));

         return true;
      }
   }

   public LoginConfirmationRequest getLoginConfirmationRequest(String id) {
      synchronized(this.requests) {
         Iterator var3 = this.requests.iterator();

         LoginConfirmationRequest loginConfirmationRequest;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            loginConfirmationRequest = (LoginConfirmationRequest)var3.next();
         } while(!loginConfirmationRequest.getId().equals(id));

         return loginConfirmationRequest;
      }
   }
}
