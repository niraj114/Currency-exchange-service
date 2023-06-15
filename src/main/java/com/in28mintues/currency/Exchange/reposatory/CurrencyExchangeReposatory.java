package com.in28mintues.currency.Exchange.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28mintues.currency.Exchange.bean.CurrencyExchange;

@Repository
public interface CurrencyExchangeReposatory extends JpaRepository<CurrencyExchange, Long>{
	
	 CurrencyExchange findByFromAndTo(String from, String to);

}
