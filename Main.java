import java.util.*;
import java.io.*;

import java.awt.Color;


public class Main
{

public static void main(String[] args)
{
if(args.length!=4)
{
System.out.println("Incorrect number of arguments: " + args.length + " supplied, 4 needed");
System.out.println("Usage: required argments are " + " jpeg filename " +   
                   "X dimension " + "Y dimension " + "Fractal number [1,9]");
System.out.println("Examples:");
System.out.println("java Main kochSnowflake.jpg 1024 1024 1");
System.out.println("java Main kochCurve.jpg 1024 1024 2");
System.out.println("java Main sierpinskiTriangle.jpg 1024 1024 3");
System.out.println("java Main dragonCurve.jpg 1024 1024 4");
System.out.println("java Main fractalPlant.jpg 1024 1024 5");
System.out.println("java Main fractalBush.jpg 1024 1024 6");
System.out.println("java Main tree1.jpg 1024 1024 7");
System.out.println("java Main tree2.jpg 1024 1024 8");
System.out.println("java Main tree3.jpg 1024 1024 9");
System.exit(0);
}

String filename=args[0];
Integer sizeX=Integer.parseInt(args[1]);
Integer sizeY=Integer.parseInt(args[2]);
int fractalNumber=Integer.parseInt(args[3]);

System.out.println("filename:" + args[0] + 
                   " sizeX=" + args[1] + " sizeY=" + args[2] + 
                   " fractalNumber=" + fractalNumber);
// Allocate the canvas
Canvas canvas = new Canvas(sizeX,sizeY);
canvas.setOriginLowerLeft();
canvas.show();

Boolean fractal1,fractal2,fractal3,fractal4,fractal5,fractal6,fractal7,fractal8,fractal9;
fractal1=false;
fractal2=false;
fractal3=false;
fractal4=false;
fractal5=false;
fractal6=false;
fractal7=false;
fractal8=false;
fractal9=false;
switch (fractalNumber) {
            case 1:  fractal1=true;
                     break;
            case 2:  fractal2=true;
                     break;
            case 3:  fractal3=true;
                     break;
            case 4:  fractal4=true;
                     break;
            case 5:  fractal5=true;
                     break;
            case 6:  fractal6=true;
                     break;
            case 7:  fractal7=true;
                     break;
            case 8:  fractal8=true;
                     break;
            case 9:  fractal9=true;
                     break;
            default: System.out.println("Incompatible fractal number entered, not in [1,9]");
                     System.exit(1);
                     break;
        }

// Koch Snowflake
if(fractal1)
{
int n=5; // number of iterations
double angle=60.0; // angle
int numSymbols=1; // number of symbols in alphabet
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("F"); // symbols in alphabet
rules[0]=new String("F+F--F+F"); // One rule per symbol
String axion="+F--F--F";
double scalingFactor=1.0;

MakeFractal kochSnowFlake = new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=kochSnowFlake.buildFractal();
kochSnowFlake.prettyPrint();
DrawFractal frac1 = new DrawFractal(computedFractal,scalingFactor,angle);
frac1.computeLines();
frac1.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal2)
{
// Koch Curve
int n=5;
double angle=90.0;
int numSymbols=1;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("F"); // symbols in alphabet
rules[0]=new String("F+F-F-F+F"); // One rule per symbol
String axion="--F";
double scalingFactor=1.0;

MakeFractal kochCurve = new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=kochCurve.buildFractal();
kochCurve.prettyPrint();
DrawFractal frac2 = new DrawFractal(computedFractal,scalingFactor,angle);
frac2.computeLines();
frac2.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal3)
{
// Sierpinski Triangle
int n=8;
double angle=120.0;
int numSymbols=2;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
// G and F are the same
symbols[0]=new String("F"); // symbols in alphabet
symbols[1]=new String("G"); // symbols in alphabet
rules[0]=new String("F-G+F+G-F"); // One rule per symbol
rules[1]=new String("GG"); // One rule per symbol
String axion="F-G-G";
double scalingFactor=1.0;

MakeFractal serpinskiTriangle=new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=serpinskiTriangle.buildFractal();
serpinskiTriangle.prettyPrint();
DrawFractal frac3 = new DrawFractal(computedFractal,scalingFactor,angle);
frac3.computeLines();
frac3.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal4)
{
// Dragon curve
int n=12;
double angle=90.0;
int numSymbols=2;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
// G and F are the same
symbols[0]=new String("X"); // symbols in alphabet
symbols[1]=new String("Y"); // symbols in alphabet
rules[0]=new String("X+YF"); // One rule per symbol
rules[1]=new String("FX-Y"); // One rule per symbol
String axion="FX";
double scalingFactor=1.0;

MakeFractal dragonCurve= new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=dragonCurve.buildFractal();
dragonCurve.prettyPrint();
DrawFractal frac4 = new DrawFractal(computedFractal,scalingFactor,angle);
frac4.computeLines();
frac4.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal5)
{
// Fractal Plant
int n=7;
double angle=25.0;
int numSymbols=2;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("X"); // symbols in alphabet
symbols[1]=new String("F"); // symbols in alphabet
rules[0]=new String("F-[[X]+X]+F[+FX]-X"); // One rule per symbol
rules[1]=new String("FF"); // One rule per symbol
String axion="----X";
double scalingFactor=1.0;

MakeFractal fractalPlant= new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=fractalPlant.buildFractal();
fractalPlant.prettyPrint();
DrawFractal frac5 = new DrawFractal(computedFractal,scalingFactor,angle);
frac5.computeLines();
frac5.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}


if(fractal6)
{
// Fractal Plant
int n=6;
double angle=16.0;
int numSymbols=1;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("F"); // symbols in alphabet
rules[0]=new String("FF-[-F+F+F]+[+F-F-F]"); // One rule per symbol
String axion="------F";
double scalingFactor=1.0;

MakeFractal fractalBush=new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=fractalBush.buildFractal();
fractalBush.prettyPrint();
DrawFractal frac6 = new DrawFractal(computedFractal,scalingFactor,angle);
frac6.computeLines();
frac6.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal7)
{
// Fractal tree1
int n=5;
double angle=22.5;
int numSymbols=2;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("F"); // symbols in alphabet
symbols[1]=new String("X"); // symbols in alphabet
rules[0]=new String("FF-[-F+F]+[+F-F]"); // One rule per symbol
rules[1]=new String("FF+[+F]+[-F]"); // One rule per symbol
String axion="----FX";
double scalingFactor=1.0;

MakeFractal fractalBush=new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=fractalBush.buildFractal();
fractalBush.prettyPrint();
DrawFractal frac7 = new DrawFractal(computedFractal,scalingFactor,angle);
frac7.computeLines();
frac7.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal8)
{
// Fractal tree2
int n=6;
double angle=22.5;
int numSymbols=2;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("X"); // symbols in alphabet
symbols[1]=new String("F"); // symbols in alphabet
rules[0]=new String("F-[[X]+X]+F[+FX]-X"); // One rule per symbol
rules[1]=new String("FF"); // One rule per symbol
String axion="----X";
double scalingFactor=1.0;

MakeFractal fractalBush=new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=fractalBush.buildFractal();
fractalBush.prettyPrint();
DrawFractal frac8 = new DrawFractal(computedFractal,scalingFactor,angle);
frac8.computeLines();
frac8.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}

if(fractal9)
{
// Fractal tree3
int n=6;
double angle=25.0;
int numSymbols=1;
String[] symbols=new String[numSymbols]; // symbols that can be used to make strings
String[] rules=new String[numSymbols]; // rules that expand each symbol
System.out.println("length of symbols:" + symbols.length);
symbols[0]=new String("F"); // symbols in alphabet
rules[0]=new String("FF[-F++F][+F--F]++F--F"); // One rule per symbol
String axion="++++++F";
double scalingFactor=1.0;

MakeFractal fractalBush=new MakeFractal(symbols,numSymbols,axion,rules,n);
String computedFractal=fractalBush.buildFractal();
fractalBush.prettyPrint();
DrawFractal frac9= new DrawFractal(computedFractal,scalingFactor,angle);
frac9.computeLines();
frac9.drawAllLines(canvas,0,0,sizeX-1,sizeY-1);
canvas.save(filename);
}


} // main method
} // Main class
