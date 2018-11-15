package calcular.ratios.modelo;

public class Ratios {
	
	private String empresa;
	private Double per;
	private Double beta;
	private Double rentabilidadDividendo;
	private Double crecimientoDividendo;
	private Double quickRatio;
	private Double currentRatio;
	private Double debtEquity;
	private Double roa;
	private Double roe;
	
	public Double getPer() {
		return per;
	}
	
	public void setPer(Double per) {
		this.per = per;
	}
	
	public Double getBeta() {
		return beta;
	}
	
	public void setBeta(Double beta) {
		this.beta = beta;
	}
	
	public Double getRentabilidadDividendo() {
		return rentabilidadDividendo;
	}
	
	public void setRentabilidadDividendo(Double rentabilidadDividendo) {
		this.rentabilidadDividendo = rentabilidadDividendo;
	}
	
	public Double getCrecimientoDividendo() {
		return crecimientoDividendo;
	}
	
	public void setCrecimientoDividendo(Double crecimientoDividendo) {
		this.crecimientoDividendo = crecimientoDividendo;
	}
	
	public Double getQuickRatio() {
		return quickRatio;
	}
	
	public void setQuickRatio(Double quickRatio) {
		this.quickRatio = quickRatio;
	}
	
	public Double getCurrentRatio() {
		return currentRatio;
	}
	
	public void setCurrentRatio(Double currentRatio) {
		this.currentRatio = currentRatio;
	}
	
	public Double getDebtEquity() {
		return debtEquity;
	}
	
	public void setDebtEquity(Double debtEquity) {
		this.debtEquity = debtEquity;
	}
	
	public Double getRoa() {
		return roa;
	}
	
	public void setRoa(Double roa) {
		this.roa = roa;
	}
	
	public Double getRoe() {
		return roe;
	}
	
	public void setRoe(Double roe) {
		this.roe = roe;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Ratios [empresa=" + empresa + ", per=" + per + ", beta=" + beta + ", rentabilidadDividendo="
				+ rentabilidadDividendo + ", crecimientoDividendo=" + crecimientoDividendo + ", quickRatio="
				+ quickRatio + ", currentRatio=" + currentRatio + ", debtEquity=" + debtEquity + ", roa=" + roa
				+ ", roe=" + roe + "]";
	}
}
