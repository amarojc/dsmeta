package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.domain.entity.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class SmsService {

		
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twiliokey;
	
	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;
	
	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;
	
	public void sendSms(Long SaleId) {
		Sale sale = saleRepository.findById(SaleId).get();
		
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear(); 
		String number = String.format("%.2f", sale.getAmount());
		
		String  msg = "O Vendedor " + sale.getSellerName() 
		+ " foi destaque em " + date + " com um total de R$ " + number
		+ " em vendas.";
		
		Twilio.init(twilioSid, twiliokey);
		
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Message message = Message.creator(to, from, msg).create();
		
		System.out.println(message.getSid());
	}
	
}