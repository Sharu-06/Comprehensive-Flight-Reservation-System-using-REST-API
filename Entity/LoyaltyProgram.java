package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loyalty_program")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoyaltyProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loyaltyID;

    @Column(name = "points_earned", nullable = false)
    private int pointsEarned;

    @Column(name = "points_redeemed", nullable = false)
    private int pointsRedeemed;

    @Column(name = "tier", nullable = false)
    private String tier;

    public LoyaltyProgram(int pointsEarned, int pointsRedeemed, String tier) {
        this.pointsEarned = pointsEarned;
        this.pointsRedeemed = pointsRedeemed;
        this.tier = tier;
    }

    public Long getLoyaltyID() {
        return loyaltyID;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        if (pointsEarned < 0) {
            throw new IllegalArgumentException("Points earned cannot be negative");
        }
        this.pointsEarned = pointsEarned;
    }

    public int getPointsRedeemed() {
        return pointsRedeemed;
    }

    public void setPointsRedeemed(int pointsRedeemed) {
        if (pointsRedeemed < 0) {
            throw new IllegalArgumentException("Points redeemed cannot be negative");
        }
        this.pointsRedeemed = pointsRedeemed;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        if (tier == null || tier.isEmpty()) {
            throw new IllegalArgumentException("Tier cannot be empty");
        }
        this.tier = tier;
    }
}
