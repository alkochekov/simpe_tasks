The bank (Bank class) has accounts (Account class) with two fields — money and AccNumber.

All accounts are stored inside the bank. Many bank customers can simultaneously transfer money between accounts and request a balance on their account. Everything happens in a highly concurrent (multithreaded) environment.

In this case, transactions for amounts > 50,000 are sent to the security service for verification. We can assume that such transactions are no more than 5% of all. A separate and already implemented method is responsible for checking Bank.is Fraud().

The security service cannot process more than one transaction at a time. The check takes 1000 ms.

If the security service has detected fraud, it is necessary to block both accounts, that is, prohibit any changes to the balances in the future.