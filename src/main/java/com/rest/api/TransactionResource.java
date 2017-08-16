package com.rest.api;
 
import com.rest.dto.TransactionDto;
import com.rest.service.TransactionService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/doTrans")
public class TransactionResource {
 
	@POST
	public Response getMsg(TransactionDto transactionDto) {
		TransactionService.doTransaction(transactionDto.getUserSenderId(),transactionDto.getAccountSenderId(),
				                         transactionDto.getUserReciverId(),transactionDto.getAccountReciverId(),transactionDto.getAmount());
		String output = "Jersey say : " + "transactionDo "+transactionDto.toString();
 
		return Response.status(200).entity(output).build();
 
	}
 
}