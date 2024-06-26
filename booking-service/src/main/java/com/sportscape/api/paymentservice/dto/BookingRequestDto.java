package com.sportscape.api.paymentservice.dto;

import com.sportscape.api.paymentservice.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRequestDto {
    private Long userId;
    private Long facilityId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalAmount;
    private PaymentMethod paymentMethod;
}
