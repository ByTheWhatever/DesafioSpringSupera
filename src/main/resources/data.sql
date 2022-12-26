CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);

INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', 'Beltrano', 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:00+03',-3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',-25173.09,'SAQUE', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2021-04-02 12:12:05+03',5173.09,'DEPOSITO', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2021-04-03 12:12:06+03',-6173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2021-04-04 12:12:07+03',-7173.09,'SAQUE', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2021-04-05 12:12:08+03',8173.09,'DEPOSITO', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11,'2021-04-06 12:12:09+03',-9173.09,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2021-04-07 12:12:10+03',-10173.09,'SAQUE', 'Ronnyscley',2);
