/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vicky
 * Created: 23-mag-2016
 */
CREATE TABLE SaldoClientiVenditori
(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	saldo DOUBLE

);

CREATE TABLE utenteCliente
(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	username VARCHAR(128),
	pwd VARCHAR(128),
	idConto INTEGER,
	FOREIGN KEY (idConto) REFERENCES SaldoClientiVenditori(id)

);


CREATE TABLE Object
(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	nome VARCHAR(128),
	url VARCHAR(128),
	descrizione VARCHAR(128),
	prezzo DOUBLE,
	idV INTEGER,
	numPezzi INTEGER,
	FOREIGN KEY (idV) REFERENCES SaldoClientiVenditori(id)

);


CREATE TABLE utenteVenditore
(
	idV INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	username VARCHAR(128),
	pwd VARCHAR(128),
	idConto INTEGER,
	FOREIGN KEY (idV) REFERENCES SaldoClientiVenditori(id)
);

