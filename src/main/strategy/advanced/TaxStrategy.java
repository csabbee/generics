package strategy.advanced;

public interface TaxStrategy <P extends TaxPayer<P>>{
	long calculateTax(P p);
}
