## Day 9
Started Project 2 (banking ledger). Kafka running in KRaft mode via Docker.
Account Service saves to Postgres and publishes AccountCreatedEvent keyed by
accountId to a 3-partition topic. Verified with kafka-console-consumer.