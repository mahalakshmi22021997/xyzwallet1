package com.capg.xyzwallet.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.exception.WalletException;
import com.capg.xyzwallet.service.IWalletService;
import com.capg.xyzwallet.service.WalletServiceImp;

public class TestWalletServiceImp {
 private static  IWalletService iWalletService=null;
 @BeforeClass
public static void createInstance(){
	iWalletService=new WalletServiceImp();
}
@Test(expected=WalletException.class)
public void testFnameForLength() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("ma");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test(expected=WalletException.class)
public void testFnameForAlphabet() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("8741");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test(expected=NullPointerException.class)
public void testFnameForNotNull() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName(null);
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test
public void testFnameForPositive() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	walletBean.setPhoneNumber("9876543210");
	boolean result=iWalletService. createAccount(walletBean);
	assertTrue(result);
}
@Test(expected=WalletException.class)
public void testLnameForLength() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("abcd");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test(expected=WalletException.class)
public void testLnameForAlphabet() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("87638276e87");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test(expected=NullPointerException.class)
public void testLnameForNotNull() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName(null);
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test
public void testLnameForPositive() throws Exception {
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha434@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	walletBean.setPhoneNumber("7416368112");
	boolean result=iWalletService. createAccount(walletBean);
	assertTrue(result);
}
@Test(expected=WalletException.class)
public void testPhoneNumberForNumber() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("mahalakshmi");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha87898@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test(expected=WalletException.class)
public void testPhoneNumberForLength() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9876543210");
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}


@Test(expected=WalletException.class)
public void testDepositAmountNumberPositive() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9867123456");
	walletBean.setBalance(-90000.00);
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test(expected=WalletException.class)
public void testAmountForPositiveValue() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9867123456");
	walletBean.setAmount(-45646);
	walletBean.setBalance(-90000.00);
	boolean result=iWalletService.validations(walletBean);
	assertFalse(result);
}
@Test
public void testAmountForPositiveCase() throws WalletException{
	WalletBean walletBean=new WalletBean();
	walletBean.setfName("maha");
	walletBean.setlName("pasumarthi");
	walletBean.setEmail("maha@gmail.com");
	walletBean.setAddress("chennai");
	walletBean.setAlternateMobileNum("9634879812");
	walletBean.setBalance(77979.98);
	walletBean.setAmount(45646);
	boolean result=iWalletService.deposit(walletBean.getAmount());
	assertTrue(result);
	

}
}

