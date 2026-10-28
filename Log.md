## Day 9
Started Project 2 (banking ledger). Kafka running in KRaft mode via Docker.
Account Service saves to Postgres and publishes AccountCreatedEvent keyed by
accountId to a 3-partition topic. Verified with kafka-console-consumer.

## Day 10
Built Notification Service consuming account-events in notification-group.
Ran 2 instances and watched partition rebalance; verified catch-up after
downtime and checked lag via kafka-consumer-groups.sh.