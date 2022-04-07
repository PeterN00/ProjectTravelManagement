/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.TicketType;
import com.tm.repository.TicketTypeRepository;
import com.tm.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;
    
    @Override
    public TicketType getTicketType(boolean type) {
        return this.ticketTypeRepository.getTicketType(type);
    }
    
}
