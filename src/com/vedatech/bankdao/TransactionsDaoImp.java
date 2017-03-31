package com.vedatech.bankdao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import com.vedatech.bank.beans.Bank;
import com.vedatech.bank.beans.SupplierInvoice;
import com.vedatech.bank.beans.TransactionsAccounts;


@Service("transDao")
@Transactional
public class TransactionsDaoImp extends AbstractDao<Integer, TransactionsAccounts> implements TransactionsDao{

	@Override
	public Bank findBankById(Integer id) {
		Criteria crit = getSession().createCriteria(Bank.class);
		crit.add(Restrictions.eq("idBank", id));
		return (Bank) crit.uniqueResult();
	}
	
	@Override
	public TransactionsAccounts findTransactionsById(Integer id) {
		Criteria crit = getSession().createCriteria(TransactionsAccounts.class);
		crit.add(Restrictions.eq("idTransactions", id));
		return (TransactionsAccounts) crit.uniqueResult();
	}


	@Override
	public List<TransactionsAccounts> getTransactionByAcc(int idBank) {
		Session session = getSession();
		Query query = session.createQuery("FROM  TransactionsAccounts mov WHERE bank.idBank=" +idBank + "ORDER BY transactionsDate ASC");
		return  query.list();
	}
	
	public List<TransactionsAccounts> getTransactionByAcc(int idBank, String stDate, String edDate) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date frmDate = format.parse(stDate);
		Date enDate = format.parse(edDate); 
		List query=getSession().createQuery("FROM TransactionsAccounts AS c WHERE c.transactionsDate BETWEEN :stDate AND :edDate AND bank.idBank="+idBank)
		.setDate("stDate", frmDate)
		.setDate("edDate", enDate)
		.list();
		return query;
	}
	
	@Override
	public void saveTransactionsToPayInvoice(TransactionsAccounts transactions, int id) {
		
			SupplierInvoice supplier = (SupplierInvoice) getSession().get(SupplierInvoice.class, id);
			System.out.println("VAMOS A GRABAR EL VALOR DE TRANSACTIONS ");
			transactions.setSupplierInvoice(supplier);
			getSession().persist(transactions);		
			//supplier.setBalance(supplier.getSupplierTotal()-transactions.getTransactionAmount());
		//	transactions.setSupplierInvoice(supplier);
		
		
	}
		
	@Override
	public void updateTransactions(TransactionsAccounts transactions) {
		Session session = getSession();
		session.update(transactions);	
	}
	
	public List<TransactionsAccounts> getBalanceById(Integer idBank){
		TransactionsAccounts result = (TransactionsAccounts) getSession().createQuery("FROM TransactionsAccounts WHERE bank.idBank=" +idBank + "ORDER BY id DESC" )
                .setMaxResults(1)
                .uniqueResult();
		System.out.println("Result Transactions Num "+ result.getTransactionNum());
		System.out.println("Result Transactions Descriptions "+ result.getTransactionsDescriptionDetails());


		
		return null;
	}
	
	/*public Double getBalanceByIdBank(Integer idBank){
		TransactionsAccounts result = (TransactionsAccounts) getSession().createQuery("FROM TransactionsAccounts WHERE bank.idBank=" +idBank + "ORDER BY id DESC" )
                .setMaxResults(1)
                .uniqueResult();
		Double balance = result.getTransactionsBalance();
		System.out.println("Result IN DOUBLE Transactions Num "+ result.getTransactionNum());
		System.out.println("Result Transactions Descriptions "+ result.getTransactionsDescriptionDetails());
		System.out.println("Result IN DOUBLE Transactions Balance "+ result.getTransactionsBalance());
		
		return balance;
	}*/
	
	public void deleteTransaction(TransactionsAccounts transaction){
		delete(transaction);
		
	}

	@Override
	public Double getBalanceByIdBank(Integer idBank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTransactions(TransactionsAccounts transactions) {
		getSession().persist(transactions);	
		
	}

	public List getSumPaymentIdInvoice(int id){
		String hql = "SELECT SUM(E.transactionAmount) FROM TransactionsAccounts E " +
	             "WHERE E.supplierInvoice.idInvoice="+id;
	Query query = getSession().createQuery(hql);
	List results = query.list();
		return results;
	}
}
