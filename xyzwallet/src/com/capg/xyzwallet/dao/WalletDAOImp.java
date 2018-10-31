package com.capg.xyzwallet.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.bean.WalletTransaction;
import com.capg.xyzwallet.exception.ExceptionMessage;
import com.capg.xyzwallet.exception.WalletException;
import com.capg.xyzwallet.service.IWalletService;
import com.capg.xyzwallet.service.WalletServiceImp;

public class WalletDAOImp implements IWalletDAO {
	IWalletService iWalletService = new WalletServiceImp();
	WalletBean bean1 = new WalletBean();

	// Scanner scanner = new Scanner(System.in);
	ArrayList<WalletBean> custList = new ArrayList<WalletBean>();

	ArrayList<WalletTransaction> transList = new ArrayList<>();
	String pattern = "dd-MM-yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	@Override
	public boolean deposit(double amount) {
		boolean isSuccessful = false;
		WalletTransaction transaction = new WalletTransaction();
		double balance;
		for (WalletBean walletBean : custList) {

			transaction.setBalance(walletBean.getBalance());

			balance = walletBean.getBalance() + amount;
			if (custList.set(0, walletBean) != null) {
				isSuccessful = true;
			}

			System.out.println(walletBean.getBalance());
			LocalDateTime date = LocalDateTime.now();

			transaction.setAmount(amount);
			transaction.settDate(date);
			transaction.settType("deposit");
			transaction.setReceipentNumber(walletBean.getPhoneNumber());
			transList.add(transaction);

		}
		return isSuccessful;
	}

	@Override
	public boolean createAccount(WalletBean bean) {

		return custList.add(bean);
		//iWalletService.validations(bean);
		
	}

	@Override
	public double showBalance() {
		WalletBean bean=new WalletBean();
		double balance=0;

		for (WalletBean walletBean : custList) {
			balance=walletBean.getBalance();
			
		}
		return balance;
	}

	@Override
	public boolean withDraw(double amount) throws WalletException {
		boolean isSuccessful = false;
		WalletTransaction transaction = new WalletTransaction();
		double balance;
		for (WalletBean walletBean : custList) {
			if (walletBean.getBalance() < amount) {
				throw new WalletException(ExceptionMessage.ERRORLOWBALANCE);
			} else {
				transaction.setBalance(walletBean.getBalance());

				balance = walletBean.getBalance() - amount;
				if (custList.set(0, walletBean) != null) {
					isSuccessful = true;
				}

				System.out.println(walletBean.getBalance());
				LocalDateTime date = LocalDateTime.now();

				transaction.setAmount(amount);
				transaction.settDate(date);
				transaction.settType("deposit");
				transaction.setReceipentNumber(walletBean.getPhoneNumber());
				transList.add(transaction);
			}

		}
		return isSuccessful;
	}

	@Override
	public boolean fundTransfer(double amount) {
	       public boolean fundTransfer(String ph1, double amount, String ph2)throws WalletException {
	              addAccount();
	              boolean b2 = false;
	              boolean match=iWalletService.validatePhNo(ph1,WalletBean.getPh2());
	              System.out.println(match);
	              
	   if(match)
	   {
	              for (WalletBean bean : custList) {
	                     System.out.println("hii");
	                     try {
	                           if (ph2.equals(bean.getPh1()))
	                           {
	                                  System.out.println("tst");
	                                  boolean with = withDraw(ph1, amount);
	                                  System.out.println("withdraw");
	                                  if (with) {
	                                         boolean dep = deposit(ph2, amount);
	                                         System.out.println("deposit");
	                                         if (dep) {
	                                                b2 = true;
	                                                System.out.println("transfered");

	                                         }

	                                  }
	                           }
	                     } catch (Exception e) {
	                           System.out.println(e.getMessage());
	                     }

	              }

	   }   System.out.println(b2);
	              return b2;
	       }

	}



		
		

		return false;
	}

	@Override
	public ArrayList<WalletTransaction> printTransaction(LocalDateTime fDate,
			LocalDateTime tDate) {
		ArrayList<WalletTransaction> result = new ArrayList<>();
		for (WalletTransaction walletTransaction : transList) {
			if (walletTransaction.gettDate().isAfter(fDate)
					&& walletTransaction.gettDate().isBefore(LocalDateTime.now())) {
                result.add(walletTransaction);
			}
		}
		return result;
	}

}