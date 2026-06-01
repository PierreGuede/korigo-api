#!/usr/bin/env bash

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

export DB_URL="${DB_URL:-jdbc:h2:file:/tmp/korigo-mobile;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH}"
export DB_DRIVER="${DB_DRIVER:-org.h2.Driver}"
export DB_USERNAME="${DB_USERNAME:-sa}"
export DB_PASSWORD="${DB_PASSWORD:-}"
export H2_CONSOLE_ENABLED="${H2_CONSOLE_ENABLED:-true}"
export CORS_ALLOWED_ORIGINS="${CORS_ALLOWED_ORIGINS:-*}"
export SERVER_ADDRESS="${SERVER_ADDRESS:-0.0.0.0}"
export SERVER_FORWARD_HEADERS_STRATEGY="${SERVER_FORWARD_HEADERS_STRATEGY:-framework}"

cd "$ROOT_DIR"
./mvnw spring-boot:run
