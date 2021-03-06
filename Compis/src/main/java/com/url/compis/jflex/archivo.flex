package com.url.compis;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;


%%

%public
%class Proyecto
%standalone
%line
%column
%char
%cup
%eofval{
    System.out.println("ENCONTRE EL FIN ARCHIVO ");
    return new Symbol(sym.EOF);
%eofval}
%eofclose

/*manera de usar codigo de java en jflex*/
%init{ 
/*Se crear los archivos donde se guardan los tokens y la demas informacion a usar*/
    
    File archivo = new File("errores.txt");
    archivo.delete();
%init}

//------------------EscribirErrores-----------------
%{
/*Metodo utilizado en el momento de detectar algun error */
    void escribirError(String nuevo)
    {
        File archivo = new File("errores.txt");
        FileWriter escribir;
        PrintWriter linea;
          try {
            archivo.createNewFile();
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            linea.println("LEX: Se encontró un error lexico en : "+nuevo);
            linea.close();
            escribir.close();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }
%}
/*EXPRESIONES DECLARADAS*/

L=[A-Z]+
l=[a-z]+
D=[0-9]+

/*PALABRAS RESERVADAS*/
entero="entero"
real="real"
cadena="cadena"
boleano="boleano"
nulo="nulo"
v="verdadero"
f="falso"
and = "AND"
or = "OR"
escribir = "escribir"
leer = "leer"
si = "si"
entonces = "entonces"
sino ="sino"
devolver = "devolver"
desde = "desde"
mientras = "mientras"
incrementar = "incrementar"
decrementar = "decrementar"
hacer = "hacer"
cadenaAEntero = "cadenaAEntero"
cadenaAReal = "cadenaAReal"
cadenaABoleano = "cadenaAboleano"
seno = "seno"
coseno = "coseno"
tangente = "tangente"
logaritmo = "logaritmo"
raiz = "raiz"
clase = "clase"
extiende = "extiende"
propiedades = "propiedades"
metodos = "metodos"
publicas = "publicas"
privadas = "privadas"
protegidas = "protegidas"
publicos = "publicos"
privados = "privados"
protegidos = "protegidos"
instanciar = "instanciar"
eliminar = "eliminar"
constructor = "constructor"
destructor = "desctructor"
incluir = "incluir"
Principal = "Principal"

/*SIGNOS*/
punto = "."
puntoComa = ";"
coma = ","
parentesisA = "("
parentesisC = ")"
comillas = "\""
guion = "_"
dosPuntos = ":"

/*OPERADORES*/
igual = "="
operadorA = "*"|"/"|"^"|"%"
mas = "+"
menos = "-"
menor = "<"
mayor = ">"
noIgual = "!="

/*IDENTIFICADOR*/
/*identificador para variables o funciones*/
identificadorVF={l}({l}|{L}|{D}|{guion})* 
identificadorC={L}({l}|{L}|{D}|{guion})*

/*NUMEROS Y CADENAS*/
numR={D}+({punto}{D}+)+
cad = {comillas}({L}|{l}|{D}|{espacio}|{operadorA}|{guion}|{punto}|{dosPuntos})*{comillas}

/*Espacios, FinLineas, Saltos de Linea, Identacion*/
espacio=[ \n]
FinLinea = \r|\n|\r\n
EspacioBlanco = {FinLinea} |[ \t\f]
tab={espacio}{4}

/*ERRORES LEXICOS*/
/*error en el identificador de una variable o Funcion*/
ErrorNVariable=({D}|{L})({l}|{L}|{D}|{guion})*  
/*error al nombrar una Clase*/
ErrorNclase=({l}|{D})({l}|{L}|{D}|{guion})*

/*COMENTARIOS*/
COMENTARIOA="/*"
COMENTARIOB="*/"
COMENTARIOC="//"

/*%   FUNCIONES ESPECIALES  
    cadenaEntero = "cadenaAEntero"
    cadenaReal = "cadenaAReal"
    cadenaBooleano = "cadenaABoleano"
    seno = "seno"
    coseno = "coseno"
    tangente = "tangente"
    logaritmo = "logaritmo"
    raiz = "raiz"
    /*%   IGNORAR  */
    findelinea = \n|\r|\rn
    ignorar = \n|\r\n|\r\n|"\ " */

/*comentario de una linea*/
ComenA={COMENTARIOC}({L}|{l}|{D}|{espacio}|{operadorA})*
/*comentario de varias lineas*/
ComenB={COMENTARIOA}({L}|{l}|{D}|{espacio}|{EspacioBlanco}|"+"|"-"|"_"|"*"|"/*")+{COMENTARIOB}

%%
{tab} {
}
{ComenA} { 
    System.out.println("LEXICO : Encontre un COMENTARIO DE UNA LINEA " + yytext());
    return new Symbol(sym.comentario);
}
{ComenB} {
    System.out.println("LEXICO : COMENTARIO DE VARIAS LINEAS " + yytext());
    return new Symbol(sym.comentario);
}
{espacio} {
    System.out.println("LEXICO : ESPACIO EN BLANCO " + yytext());
    return new Symbol(sym.espacioBlanco);
}
{EspacioBlanco} {
    System.out.println("LEXICO: encontre un Fin de Linea " + (yyline+1));
    return new Symbol(sym.finLinea);
}
{puntoComa} {
    System.out.println("LEXICO : Encontre un SIGNO " + yytext());
    return new Symbol(sym.puntoComa);
}
{coma} {
    System.out.println("LEXICO : Encontre un SIGNO " + yytext());
    return new Symbol(sym.coma);
}
{cad} {
    System.out.println("LEXICO : Encontre una CADENA " + yytext());
    return new Symbol(sym.texto);
}
{incluir} { 
    System.out.println("LEXICO : PALABRA RESERVADA " + yytext());
    return new Symbol(sym.incluir);
}
{clase} { 
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.clase);
}
{extiende} { 
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.extiende);
}
{entero} { 
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());;
    return new Symbol(sym.entero);
}
{real} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());; 
    return new Symbol(sym.real);
}
{cadena} { 
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());;
    return new Symbol(sym.cadena);
}
{boleano} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.boleano);
}
{nulo} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.nulo);
}
{propiedades} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.propiedades);
}
{metodos} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.metodos);
}
{publicas} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.publicas);
}
{privadas} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.privadas);
}
{protegidas} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.protegidas);
}
{publicos} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.publicos);
}
{privados} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.privados);
}
{protegidos} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.protegidos);
}

{v} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.verdadero);
}
{f} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.falso);
}
{identificadorVF} {
    System.out.println("LEXICO : Encontre un IDENTIFICADOR " + yytext());
    return new Symbol(sym.identificadorVF);
}
{identificadorC} {
    System.out.println("LEXICO : Encontre un IDENTIFICADOR " + yytext());
    return new Symbol(sym.identificadorC);
}
{numR} {
    System.out.println("LEXICO : Encontre un NUMERO REAL " + yytext());
    return new Symbol(sym.numeroR);}
{D} {
    System.out.println("LEXICO : Encontre un NUMERO " + yytext());
    return new Symbol(sym.numero);
}
{igual} {
    System.out.println("LEXICO : Encontre un SIGNO " + yytext());
    return new Symbol(sym.igual);
}

{parentesisC} {
    System.out.println("LEXICO : encontre un SIGNO " + yytext());
    return new Symbol(sym.parentesisC);
}
{parentesisA} {
    System.out.println("LEXICO : encontre un SIGNO " + yytext());
    return new Symbol(sym.parentesisA);
}
{dosPuntos} {
    System.out.println("LEXICO : encontre un SIGNO " + yytext());
    return new Symbol(sym.dosPuntos);
}

/*

{and} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.and);
}
{or} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.or);
}
{escribir} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.escribir);
}
{leer} {
    System.out.println("LEXICO : Encontre una PALABRA RESERVADA " + yytext());
    return new Symbol(sym.leer);
}

{comillas} {
    System.out.println("LEXICO : Encontre un SIGNO " + yytext());
    return new Symbol(sym.comillas);
}

{operadorA} {
    System.out.println("LEXICO : Encontre un OPERADOR " + yytext());
    return new Symbol(sym.OperadorA);
}
{mas} {
    System.out.println("LEXICO : Encontre un OPERADOR " + yytext());
    return new Symbol(sym.mas);
}
{menos} {
    System.out.println("LEXICO : Encontre un OPERADOR " + yytext());
    return new Symbol(sym.menos);
}

*/
. {
/*de cualquier error usamos el metodo para eliminar lo anterior y solo guarda el error*/
    String linea = String.valueOf(yyline+1);
    System.out.println("LEXICO:  encontre un error " + linea);
    escribirError(linea);
    return new Symbol(sym.error);
}