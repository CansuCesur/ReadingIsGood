package com.example.ReadingIsGood.Models;

public class Statistic {

    private int month;
    private int totalOrderCount;
    private int totalBookCount;
    private double totalPurchasedAmount;

    public Statistic(int month, int totalOrderCount, int totalBookCount, double totalPurchasedAmount) {
        this.month = month;
        this.totalOrderCount = totalOrderCount;
        this.totalBookCount = totalBookCount;
        this.totalPurchasedAmount = totalPurchasedAmount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(int totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(int totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public double getTotalPurchasedAmount() {
        return totalPurchasedAmount;
    }

    public void setTotalPurchasedAmount(double totalPurchasedCount) {
        this.totalPurchasedAmount = totalPurchasedCount;
    }

}
