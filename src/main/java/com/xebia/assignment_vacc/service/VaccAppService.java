package com.xebia.assignment_vacc.service;

import com.xebia.assignment_vacc.dao.OrderRepository;
import com.xebia.assignment_vacc.dao.VaccAppDao;
import com.xebia.assignment_vacc.entities.Model;
import com.xebia.assignment_vacc.entities.Order;
import com.xebia.assignment_vacc.utility.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccAppService {

    private static final String CLASS_NAME = VaccAppService.class.getName();
    private static final Logger log = LoggerFactory.getLogger(CLASS_NAME);


    @Autowired
    private VaccAppDao dao;
    @Autowired
    private OrderRepository orderRepo;

    public Iterable<Model> getAllBranches() {
        return dao.findAll();
    }

    public Model createBranch(Model branch) {
        return dao.save(branch);
    }

    public Optional<Model> getBranchById(Integer id) {
        Optional<Model> byId = dao.findById(id);
        return byId;
    }

    public String makeOrder(Order orderSummary) {
        String mailStatus = null;
        try {
            orderRepo.save(orderSummary);
            System.out.println("order placed successfully:");
            mailStatus = MailSender.sendEmail(orderSummary.getUserEmail());
            return mailStatus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mailStatus;
    }

    public Optional<Model> getBranchByAvailability(String branchName) {
        return dao.findByBranchAvailability(branchName);
    }

    public Optional<Model> getByBranch(String branchName) {
        return dao.findByBranchName(branchName);
    }

    public Iterable<Order> getAllOrder() {
        return orderRepo.findAll();
    }
}


