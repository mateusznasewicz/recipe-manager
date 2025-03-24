psql -c "DROP DATABASE IF EXISTS ${DB_NAME}";
psql -c "CREATE DATABASE ${DB_NAME} OWNER ${DB_USER}";
psql -c "\i db.sql"