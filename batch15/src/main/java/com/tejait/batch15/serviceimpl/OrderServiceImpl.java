package com.tejait.batch15.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.OrdersRequestDto;
import com.tejait.batch15.exceptions.DataNotFoundException;
import com.tejait.batch15.model.Customer;
import com.tejait.batch15.model.Orders;
import com.tejait.batch15.repository.CustomerRepository;
import com.tejait.batch15.repository.OrderRepository;
import com.tejait.batch15.service.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
	
	OrderRepository repository;
	CustomerRepository customerRepository;
	
	
	
	@Override
	public OrdersRequestDto saveOrders(OrdersRequestDto dto) {
		Customer customer=customerRepository.findById(dto.getCustomerId())
				.orElseThrow(()-> new DataNotFoundException("customer not found"));
		List<Orders> orderslist=dto.getOrders();  // MOBILES , CLOTHS , TOYS
		for(Orders order:orderslist) {
			order.setCustom(customer);   //  KRISHNA - FOREIGN KEY 
		}
		 
		// dto.getOrders().forEach(order->order.setCustom(customer));
		List<Orders> savedOrderList=repository.saveAll(orderslist);
		
		OrdersRequestDto responseDto=new OrdersRequestDto();
		responseDto.setOrders(savedOrderList);
		responseDto.setCustomerId(dto.getCustomerId());
		return responseDto;
	}


}
