package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class DescontoEstudante implements Desconto {
	

	@Override
	public BigDecimal aplicaDesconto(BigDecimal precoOriginal) {
		return precoOriginal.multiply(new BigDecimal("0.5"));
	}

	
}
