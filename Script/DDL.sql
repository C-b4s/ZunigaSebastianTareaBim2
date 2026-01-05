-- database: ../DataBase/EXOBOT.sqlite
/*
|----------------------------------------------|
|  (©) 2K26 EPN-FIS, All rights reserved.      |
|  szuniga046@gmail.com          c-bit         |
|----------------------------------------------|


Autor: Sebastián Zúñiga
Fecha Creación: 04.enero.2K26
Script: Creación de la estructura de datos para Exabot
*/

PRAGMA foreign_keys = ON;

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Exobot;
DROP TABLE IF EXISTS Catalogo;
DROP TABLE IF EXISTS CatalogoTipo;
DROP TABLE IF EXISTS IABOT; 

CREATE TABLE CatalogoTipo(
     IdCatalogoTipo         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , Nombre                 VARCHAR(35) NOT NULL UNIQUE
   , Descripcion            VARCHAR(200) 
   , Estado                 CHAR(1) NOT NULL DEFAULT('A')
   , FechaCreacion          DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
   , FechaModificacion      DATETIME 
);

CREATE TABLE Catalogo(
     IdCatalogo            INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , IdCatalogoTipo        INTEGER NOT NULL REFERENCES CatalogoTipo(IdCatalogoTipo)
   , Nombre                VARCHAR(35) NOT NULL
   , Descripcion           VARCHAR(200)  
   , Estado                VARCHAR(1) NOT NULL DEFAULT('A')
   , FechaCreacion         DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
   , FechaModificacion     DATETIME 
);  

CREATE TABLE IABOT(
     IdIABOT              INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , Nombre               TEXT NOT NULL UNIQUE
   , Observacion          TEXT
   , FechaCreacion        DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
   , FechaModificacion    DATETIME 
);

CREATE TABLE Exobot(
      IdExobot            INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    , IdIABOT             INTEGER NOT NULL
    , Nombre              TEXT NOT NULL 
    , Serie               TEXT NOT NULL
    , FechaCreacion       DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    , FechaModificacion   DATETIME 
    , CONSTRAINT fk_IABot FOREIGN KEY (IdIABOT) REFERENCES IABOT(IdIABOT)
);

-- CREATE TABLE PersonaTipo(
--       IdPersonaTipo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
--     , Descrpicion VARCHAR(90) NOT NULL UNIQUE
--     , FechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP

-- );

CREATE TABLE Persona(
      IdPersona             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    , IdCatalogoTipoPersona INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    , IdCatalogoSexo        INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    , IdCatalogoEstadoCivil INTEGER NOT NULL REFERENCES Catalogo(IdCatalogo)
    , Cedula                VARCHAR (10) NOT NULL UNIQUE
    , Nombre                VARCHAR (50) NOT NULL  
    , Apellido              VARCHAR (50) NOT NULL  

    , Estado                VARCHAR(1) NOT NULL DEFAULT('A')
    , FechaCreacion         DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    , FechaModificacion     DATETIME
);

