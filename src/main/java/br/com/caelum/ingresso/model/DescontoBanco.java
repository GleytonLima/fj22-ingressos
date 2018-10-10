package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class DescontoBanco implements Desconto{

	@Override
	public BigDecimal aplicaDesconto(BigDecimal precoOriginal) {
		return precoOriginal.subtract(new BigDecimal("5.00"));
	}
	
}
