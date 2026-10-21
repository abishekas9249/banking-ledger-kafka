package com.learn.account_service.utils;

import java.math.BigDecimal;
import java.time.Instant;

public record AccountCreatedEvent(Long accountId, String holderName, BigDecimal balance, Instant createdAt) {
}
