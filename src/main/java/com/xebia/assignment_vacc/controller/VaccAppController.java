package com.xebia.assignment_vacc.controller;

import com.xebia.assignment_vacc.entities.Model;
import com.xebia.assignment_vacc.entities.Order;
import com.xebia.assignment_vacc.service.VaccAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class VaccAppController {

    private static final String CLASS_NAME = VaccAppController.class.getName();
    private static final Logger log = LoggerFactory.getLogger(CLASS_NAME);

    @Autowired
    private VaccAppService service;

    @GetMapping(value = "/allbranches")
    public Iterable<Model> getAllBranches() {
        log.info("getAllBranches controller:");
        return service.getAllBranches();
    }

    @PostMapping(value = "/create/branch")
    public Model createBranch(@RequestBody Model branch) {
        log.info("Create Branch controller:");
        return service.createBranch(branch);
    }

    @PostMapping(value = "/order/vacciene")
    public String createOrder(@RequestBody Order orderSummary) {
        log.info("createOrder controller:");
        String status = service.makeOrder(orderSummary);
        return status;
    }

    @GetMapping(value = "/branchId/{branchId}")
    public Optional<Model> getBranchById(@PathVariable("ticketId") Integer branchId) {
        log.info("getBranchById controller:");
        return service.getBranchById(branchId);
    }

    @GetMapping(value = "/availability/{branchName}")
    public Optional<Model> getBranchByAvailability(@PathVariable("branchName") String branchName) {
        log.info("getBranchByAvailability controller:");
        return service.getBranchByAvailability(branchName);
    }

    @GetMapping(value = "/branch/{branchName}")
    public Optional<Model> getByBranchName(@PathVariable("branchName") String branchName) {
        log.info("getByBranchName controller:");
        return service.getByBranch(branchName);
    }

    @GetMapping(value = "/allOrder/")
    public Iterable<Order> getALlOrder() {
        log.info("getALlOrder controller:");
        return service.getAllOrder();
    }


}



