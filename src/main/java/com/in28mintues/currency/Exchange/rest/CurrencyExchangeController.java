package com.in28mintues.currency.Exchange.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28mintues.currency.Exchange.bean.CurrencyExchange;
import com.in28mintues.currency.Exchange.reposatory.CurrencyExchangeReposatory;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	public CurrencyExchangeReposatory currencyExchangeReposatory;
	
	@Autowired
	public Environment environment;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange currencyExchange(@PathVariable("from") String from, @PathVariable("to") String to) {
		
		
		
		CurrencyExchange currencyExchange = currencyExchangeReposatory.findByFromAndTo(from, to);
		
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, "USD", "INR", BigDecimal.valueOf(50));
		String port = environment.getProperty("local.server.port");
		if(currencyExchange!=null) {
		currencyExchange.setEnv(port);
		}else {
			throw new RuntimeException("no data ");
		}
		return currencyExchange;
		
	}

}
