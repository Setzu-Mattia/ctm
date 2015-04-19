package it.unica.isw.ctm.tickets.exceptions;


import java.util.Date;

public class ExpireDateException extends RuntimeException {

	private Date date;
	
	
	public ExpireDateException (){	
		this.date = new Date(System.currentTimeMillis());
	}
	
	public ExpireDateException (Date date){	
		this.date = date;		
	}
	
	@Override
	public String getMessage() {
		return "Date is in the past: " + date.toString();
	}
	
}
