/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author user
 */
class Payment {
    private String PaymentId;
    private String PaymentType;
    private String PaymentDate;
    private String PaymentTime;
    private Float PaymentAmount;
    
    public void Payment(String paymetnId, String paymentType, String paymentDate, String paymentTime, Float paymentAmount){
        this.PaymentId = paymetnId;
        this.PaymentType = paymentType;
        this.PaymentDate = paymentDate;
        this.PaymentTime = paymentTime;
        this.PaymentAmount = paymentAmount;
    }
    
}
