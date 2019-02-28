package model;

public class Payables {
	
	private String InvoiceID;
	private double amountCharged;
	private String dueDate;
	private String datePaid;
	private String status;
	
	public Payables() {
		InvoiceID = "";
		amountCharged = 0.00;
		dueDate ="";
		datePaid = "";
		status = "";
	}

	public Payables(String invoiceID, double amountCharged, String dueDate, String datePaid, String status) {
		InvoiceID = invoiceID;
		this.amountCharged = amountCharged;
		this.dueDate = dueDate;
		this.datePaid = datePaid;
		this.status = status;
	}

	public String getInvoiceID() {
		return InvoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		InvoiceID = invoiceID;
	}

	public double getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(double amountCharged) {
		this.amountCharged = amountCharged;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payables [InvoiceID=" + InvoiceID + ", amountCharged=" + amountCharged + ", dueDate=" + dueDate
				+ ", datePaid=" + datePaid + ", status=" + status + "]";
	}
	
	
	

}
