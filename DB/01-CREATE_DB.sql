-- Uruchamiamy serwer: mysqld.exe
-- Odpalamy klienta mysql z poziomu roota: .\mysql.exe -u root

-- Tworzymy bazke
CREATE DATABASE IF NOT EXISTS ewallet;
-- User z haslem i granty na polaczenie
GRANT ALL PRIVILEGES ON ewallet.* TO 'ewallet'@'%' identified by '987ewallet321';
GRANT ALL PRIVILEGES ON ewallet.* TO 'ewallet'@localhost identified by '987ewallet321';
-- Osobiscie preferuje MODE ORACLE, ale ustawiacie jakie uważacie za wygodne
SET sql_mode = 'ORACLE';
SET GLOBAL sql_mode = 'ORACLE';