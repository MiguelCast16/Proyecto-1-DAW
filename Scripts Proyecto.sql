REM *********************************************************
REM ************ EMPRESAS *******************************
REM *********************************************************
DROP TABLE Empresas cascade constraints;
CREATE TABLE Empresas (
Num_Convenio VARCHAR2(255) PRIMARY KEY,
CIF VARCHAR2(255) NOT NULL,
Representante VARCHAR2(255) NOT NULL,
NIF_Representante VARCHAR2(255) NOT NULL,
Apellidos VARCHAR2(255) NOT NULL,    
Nombre VARCHAR2(255) NOT NULL,
Pais VARCHAR2(255) NOT NULL,
Ciudad VARCHAR2(255) NOT NULL,    
Provincia VARCHAR2(255) NOT NULL,
Direccion VARCHAR2(255) NOT NULL,    
CP VARCHAR2(255) NOT NULL,    
Telefono NUMBER NOT NULL,
Fax NUMBER NOT NULL,
Ciudad_FirmaConvenio VARCHAR2(255) NOT NULL,
Fecha_FirmaConvenio VARCHAR2 (255) NOT NULL,
Familia_Profesional VARCHAR2(255) NOT NULL,
Codigo_Centro VARCHAR2(255),
FOREIGN KEY(Codigo_Centro) REFERENCES Centro(Codigo_Centro) ON DELETE CASCADE    
);



REM *********************************************************
REM ************ TUTOR PRACTICAS *******************************
REM *********************************************************
DROP TABLE Tutor_Practicas cascade constraints;
CREATE TABLE Tutor_Practicas (
NIF VARCHAR2(255) PRIMARY KEY,
Nombre VARCHAR2(255) NOT NULL,
Apellidos VARCHAR2(255) NOT NULL,
Telefono NUMBER(9) NOT NULL,
Email VARCHAR2(255) NOT NULL,
Num_Convenio VARCHAR2(255) NOT NULL,
FOREIGN KEY(Num_Convenio) REFERENCES Empresas (Num_Convenio) ON DELETE CASCADE    
);



REM *********************************************************
REM ************ TUTOR *******************************
REM *********************************************************
DROP TABLE Tutor cascade constraints;
CREATE TABLE Tutor (
NIF VARCHAR2(255) PRIMARY KEY,
Nombre VARCHAR2(255) NOT NULL,
Apellidos VARCHAR2(255) NOT NULL,
Email VARCHAR2(255) NOT NULL
);



REM *********************************************************
REM ************ CICLOS *******************************
REM *********************************************************
DROP TABLE Ciclos cascade constraints;
CREATE TABLE Ciclos (
Codigo NUMBER PRIMARY KEY,
Nombre VARCHAR2(255) NOT NULL,
Tipo VARCHAR2(255) NOT NULL,
Familia_Profesional VARCHAR2(255) NOT NULL,
Capacidades VARCHAR2(255) NOT NULL,
Actividades VARCHAR2(255) NOT NULL, 
Criterios_Evaluacion VARCHAR2(255) NOT NULL,
Clave_FP VARCHAR2(255) NOT NULL    
);



REM *********************************************************
REM ************ ALUMNOS *******************************
REM *********************************************************
DROP TABLE Alumnos cascade constraints;
CREATE TABLE Alumnos (
NIF VARCHAR2(255) PRIMARY KEY,
Nombre VARCHAR2(255) NOT NULL,
Apellidos VARCHAR2(255) NOT NULL,
Telefono NUMBER(9) NOT NULL,
Email VARCHAR2(255) NOT NULL
);



REM *********************************************************
REM ************ CENTRO *******************************
REM *********************************************************
DROP TABLE Centro cascade constraints;
CREATE TABLE Centro (
Codigo_Centro VARCHAR2(255) PRIMARY KEY,
Director_Centro VARCHAR2(255) NOT NULL,
Director_Apellidos VARCHAR(255) NOT NULL,
NIF_Director VARCHAR2(255) NOT NULL,
Nombre VARCHAR2(255) NOT NULL, 
Ciudad VARCHAR2(255) NOT NULL,
Provincia VARCHAR2(255) NOT NULL,
Direccion VARCHAR2(255) NOT NULL,
CP VARCHAR(255) NOT NULL,
CIF VARCHAR2(255) NOT NULL,
Telefono NUMBER NOT NULL,
Fax NUMBER NOT NULL,
DAT VARCHAR2(255) NOT NULL    
);



REM *********************************************************
REM ************ CURSAN *******************************
REM *********************************************************
DROP TABLE Cursan cascade constraints;
CREATE TABLE Cursan (
NIF VARCHAR2(255),
Codigo NUMBER,
Año_Curso VARCHAR2(255),
PRIMARY KEY (NIF,Codigo),
FOREIGN KEY(NIF) REFERENCES Alumnos(NIF) ON DELETE CASCADE,
FOREIGN KEY(Codigo) REFERENCES Ciclos(Codigo) ON DELETE CASCADE    
);




REM *********************************************************
REM ************ ASIGNAN_EMPRESA *******************************
REM *********************************************************
DROP TABLE Asignan_Empresa cascade constraints;
CREATE TABLE Asignan_Empresa (
NIF_Alumno VARCHAR2(255),
NUM_Convenio VARCHAR2(255),
NIF_Tutor VARCHAR2(255),
NIF_TutorEmpresa VARCHAR2(255),    
PRIMARY KEY (NIF_Alumno,Num_Convenio,NIF_Tutor,NIF_TutorEmpresa),
FOREIGN KEY(NIF_Alumno) REFERENCES Alumnos(NIF) ON DELETE CASCADE,
FOREIGN KEY(Num_Convenio) REFERENCES Empresas(Num_Convenio) ON DELETE CASCADE,
FOREIGN KEY(NIF_Tutor) REFERENCES Tutor(NIF) ON DELETE CASCADE,
FOREIGN KEY(NIF_TutorEmpresa) REFERENCES Tutor_Practicas(NIF) ON DELETE CASCADE,    
Fecha_Inicio VARCHAR2 (255) NOT NULL,
Fecha_Fin VARCHAR2 (255) NOT NULL,
Horas_Dia NUMBER NOT NULL,
Horas_Total NUMBER NOT NULL,
Horas_TardeInicio VARCHAR2(255) NOT NULL,
Horas_TardeFin VARCHAR2(255) NOT NULL,
Horas_MañanaInicio VARCHAR2(255) NOT NULL,
Horas_MañanaFin VARCHAR2(255) NOT NULL    
);