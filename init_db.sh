source ./.env
psql -c "SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = '${DB_NAME}' AND pid <> pg_backend_pid();"
psql -c "DROP DATABASE IF EXISTS ${DB_NAME}"
psql -c "CREATE DATABASE ${DB_NAME} OWNER ${DB_USER}"
psql -d ${DB_NAME} -c "\i db.sql"
psql -d ${DB_NAME} -c "\i sample.sql"