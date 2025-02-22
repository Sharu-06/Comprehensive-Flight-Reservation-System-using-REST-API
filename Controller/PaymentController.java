package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Payment;
import com.example.demo.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //http://localhost:8080/api/payments
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    //http://localhost:8080/api/payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    //http://localhost:8080/api/payments/{id}
    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    //http://localhost:8080/api/payments/{id}
    @PutMapping("/{id}")
    public Optional<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        return paymentService.updatePayment(id, paymentDetails);
    }

    //http://localhost:8080/api/payments/{id}
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        boolean isDeleted = paymentService.deletePayment(id);
        return isDeleted ? "Payment record deleted successfully!" : "Payment record not found!";
    }
}


/*
 {
  "amount": 250.75,
  "paymentDate": "2025-02-22T14:45:30",
  "paymentMethod": "Credit Card"
}

 */