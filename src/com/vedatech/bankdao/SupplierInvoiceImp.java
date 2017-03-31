package com.vedatech.bankdao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.vedatech.bank.beans.Bank;
import com.vedatech.bank.beans.SupplierInvoice;

@Service("supplierDao")
@Transactional
public class SupplierInvoiceImp extends AbstractDao<Integer, SupplierInvoice> implements SupplierInvoiceDao {

	@Override
	public List<SupplierInvoice> findAllInvoice() {
		
		String hql = "FROM SupplierInvoice AS c WHERE c.balance > 0";
	Query query = getSession().createQuery(hql);
	List results = query.list();
		return results;
		/*Criteria criteria = createEntityCriteria();
		return (List<SupplierInvoice>) criteria.list();*/
	}

	@Override
	public SupplierInvoice findInvoiceById(Integer id) {
		Criteria crit = getSession().createCriteria(SupplierInvoice.class);
		crit.add(Restrictions.eq("idInvoice", id));
		return (SupplierInvoice) crit.uniqueResult();
	}

	@Override
	public void saveTransactions(SupplierInvoice invoice) {
		// TODO Auto-generated method stub
		getSession().persist(invoice);
		
	}

	@Override
	public void updateBalance(Double totalPayments, int idInvoice) {
		SupplierInvoice supplier = (SupplierInvoice) getSession().get(SupplierInvoice.class, idInvoice);
		System.out.println("VALOR DE TOTAL PAYMENTS "+ totalPayments);
		System.out.println("VALOR DE SUPPLIER TOTAL "+ supplier.getSupplierTotal());
	supplier.setBalance(supplier.getSupplierTotal()-totalPayments);
	getSession().update(supplier);
		
		
	}
}
