package com.learn.notification_service.event;

import java.math.BigDecimal;
import java.time.Instant;

public record AccountCreatedEvent(Long accountId, String holderName, BigDecimal balance, Instant createdAt) {
}
