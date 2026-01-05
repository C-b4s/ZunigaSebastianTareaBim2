-- database: ../DataBase/ZSEXOBOT.sqlite
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

DROP TABLE IF EXISTS ZSPersona;
DROP TABLE IF EXISTS ZSExobot;
DROP TABLE IF EXISTS ZSCatalogo;
DROP TABLE IF EXISTS ZSZSCatalogoTipo;
DROP TABLE IF EXISTS ZSIABOT; 

CREATE TABLE ZSCatalogoTipo(
     IdZSCatalogoTipo         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , ZSNombre                 VARCHAR(35) NOT NULL UNIQUE
   , ZSDescripcion            VARCHAR(200) 
   , ZSEstado                 CHAR(1) NOT NULL DEFAULT('A')
   , ZSFechaCreacion          DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
   , ZSFechaModificacion      DATETIME 
);

CREATE TABLE ZSCatalogo(
     IdZSCatalogo            INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , IdZSCatalogoTipo        INTEGER NOT NULL REFERENCES ZSCatalogoTipo(IdZSCatalogoTipo)
   , ZSNombre                VARCHAR(35) NOT NULL
   , ZSDescripcion           VARCHAR(200)  
   , ZSEstado                VARCHAR(1) NOT NULL DEFAULT('A')
   , ZSFechaCreacion         DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
   , ZSFechaModificacion     DATETIME 
);  

CREATE TABLE ZSIABOT(
     IdZSIABOT              INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
   , ZSNombre               TEXT NOT NULL UNIQUE
   , ZSObservacion          TEXT
   , ZSFechaCreacion        DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
   , ZSFechaModificacion    DATETIME 
);

CREATE TABLE ZSExobot(
      IdZSExobot            INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    , IdZSIABOT             INTEGER NOT NULL
    , ZSNombre              TEXT NOT NULL 
    , ZSSerie               TEXT NOT NULL
    , ZSFechaCreacion       DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    , ZSFechaModificacion   DATETIME 
    , CONSTRAINT fk_IABot FOREIGN KEY (IdZSIABOT) REFERENCES ZSIABOT(IdZSIABOT)
);

-- CREATE TABLE PersonaTipo(
--       IdPersonaTipo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
--     , Descrpicion VARCHAR(90) NOT NULL UNIQUE
--     , FechaCreacion DATETIME DEFAULT CURRENT_TIMESTAMP

-- );

CREATE TABLE ZSPersona(
      IdZSPersona             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    , IdZSCatalogoTipoPersona INTEGER NOT NULL REFERENCES ZSCatalogo(IdZSCatalogo)
    , IdZSCatalogoSexo        INTEGER NOT NULL REFERENCES ZSCatalogo(IdZSCatalogo)
    , IdZSCatalogoEstadoCivil INTEGER NOT NULL REFERENCES ZSCatalogo(IdZSCatalogo)
    , ZSCedula                VARCHAR (10) NOT NULL UNIQUE
    , ZSNombre                VARCHAR (50) NOT NULL  
    , ZSApellido              VARCHAR (50) NOT NULL  

    , ZSEstado                VARCHAR(1) NOT NULL DEFAULT('A')
    , ZSFechaCreacion         DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    , ZSFechaModificacion     DATETIME
);

