-- database: ../DataBase/ZSEXOBOT.sqlite
/*
|----------------------------------------------|
|  (©) 2K26 EPN-FIS, All rights reserved.      |
|  szuniga046@gmail.com          c-bit         |
|----------------------------------------------|


Autor: Sebastián Zúñiga
Fecha Creación: 04.enero.2K26
Script: Insertando catálogo
*/  


INSERT OR IGNORE INTO ZSCatalogoTipo (ZSNombre, ZSDescripcion) VALUES 
('Tipo Persona', 'Tipos de personas: soldado, mecanico, etc.')
,('Sexo', 'Sexo de las personas: masculino, femenino, asexual o híbrido')
,('Estado Civil', 'Estado Civil de las personas: Sol, cas, viu, etc.')
,('Etnia', 'Etnia de las personas: Negro, blanco, mestizo, etc.');

INSERT INTO ZSCatalogo 
  (IdZSCatalogoTipo, ZSNombre           , ZSDescripcion     ) VALUES
  (    1         , 'Soldado'         , 'tipos de personas para el ejercito')--1
 ,(    1         , 'Mecanico'        , 'tipos de personas para el ejercito')--2
 ,(    1         , 'Experto Ingles'  , 'tipos de personas para el ejercito')--3
 ,(    1         , 'Experto Espanol' , 'tipos de personas para el ejercito')--4

 ,(    2         , 'Masculino'       , 'tipos de sexualidad')--5
 ,(    2         , 'Femenino'        , 'tipos de sexualidad')--6
 ,(    2         , 'Hibrido'         , 'tipos de sexualidad')--7
 ,(    2         , 'Asexual'         , 'tipos de sexualidad')--8

 ,(    3         , 'Soltero'         , 'tipos de estado civil en Ecuador')--9
 ,(    3         , 'Casado'          , 'tipos de estado civil en Ecuador')--10
 ,(    3         , 'Viudo'           , 'tipos de estado civil en Ecuador')--11
 ,(    3         , 'Divorciado'      , 'tipos de estado civil en Ecuador')--12

 ,(    4         , 'Negro'           , 'tipos de etnia')
 ,(    4         , 'Blanco'          , 'tipos de etnia')
 ,(    4         , 'Mestizo'         , 'tipos de etnia')
 ,(    4         , 'Indigena'        , 'tipos de etnia');

INSERT INTO ZSIABot (ZSNombre   , ZSObservacion  )
VALUES            ('IA-RUSO', "Inteligencia Artificial");

INSERT INTO ZSExobot 
 (IdZSIABot      ,      ZSNombre,          ZSSerie) VALUES
 (1            , 'exobot1', 'Serie E1')
,(1            , 'exobot2', 'Serie E1');

INSERT INTO ZSPersona(IdZSCatalogoTipoPersona ,IdZSCatalogoSexo ,IdZSCatalogoEstadoCivil ,ZSCedula  ,ZSNombre  ,ZSApellido) VALUES
                   (1                     ,       5       ,           9          ,"12321" ,"Sebas" ,"Putin"),               
                   (2                     ,       5       ,           10         ,"14235" ,"Andres","Garcia"),
                   (3                     ,       5       ,           11         ,"23854" ,"Julian","Perez"),
                   (4                     ,       5       ,           12         ,"23539" ,"Carlos","Haro"),
                   (1                     ,       6       ,           9          ,"32523" ,"Romina","Pico"),
                   (2                     ,       6       ,           10         ,"26436" ,"Sofia" ,"Lopez"),
                   (3                     ,       6       ,           11         ,"64644" ,"Maria" ,"Putin"),
                   (4                     ,       6       ,           12         ,"74574" ,"Taylor","Smith");

PRAGMA database_list;


SELECT
    IdZSCatalogo,
    IdZSCatalogoTipo,
    ZSNombre,
    ZSDescripcion,
    ZSEstado,
    ZSFechaCreacion,
    ZSFechaModificacion
FROM ZSCatalogo
WHERE ZSNombre IN ('Masculino', 'Femenino', 'Hibrido', 'Asexual');

SELECT COUNT(*) TotalReg
FROM    ZSCatalogo        
WHERE ZSEstado = 'A'    
AND IdZSCatalogoTipo = 2;

CREATE UNIQUE INDEX idx_sexo
ON ZSCatalogo (ZSNombre);
