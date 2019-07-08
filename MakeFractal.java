import java.util.Arrays;
import java.util.Stack;

public class MakeFractal { 
private final static int NOT_FOUND=-1;
private String alphaNumeric;
private String computedFractal; // the initial string is the axion
private String initialAxion; // the initial string is the axion
private Integer index,numSymbols,n,size; 
private String[] symbols;
private String[] rules;
private Integer charsPerLine=60;

// constructor
public MakeFractal(String[] symbols,Integer numSymbols,
                   String initialAxion,String[] rules,Integer n) {
this.numSymbols=numSymbols;
this.symbols=new String[this.numSymbols];
this.rules=new String[this.numSymbols];
for(int i=0;i<this.numSymbols;i++) {
   this.symbols[i]=symbols[i];
   this.rules[i]=rules[i];
   }
this.computedFractal=initialAxion;     // the initial string is the axion
this.n=n;
}

public String buildFractal() {
System.out.println("In buildFractal\n");
// print out symbols and their production rules
System.out.println("Symbol Table");
for(int i=0;i<numSymbols;i++) {
    System.out.println("symbol(" + i + ")=" + symbols[i] + 
                       "   rule(" + i +")=" + rules[i] + "\n");
}

// s is a stack
StackADT<String> symStack = new LinkedStack<String>();


//**** YOUR CODE HERE ****
/**
 * Build Fractal method written by Spencer Poultney 250982673
 */

//loop runs based on given n value
for (int i =1; i <= this.n; i++) {
	//loops through computedFractal each char/symbol 
	for (int j=0; j < this.computedFractal.length(); j++) {
		
		String q = this.computedFractal.substring(j, j+1);
		
		for (int e =0; e < symbols.length; e++){
			if (q.equals(symbols[e])){
				symStack.push(rules[e]);
				break;
			}
			else if (e == (symbols.length -1)){
				symStack.push(q);
			}
		}
	}
	this.computedFractal = "";
	while (!symStack.isEmpty()){
		String pop = symStack.pop();
		computedFractal = pop + computedFractal;	
	}
}
return computedFractal;
}

// Return the index of the character in symbols 
// or -1 if it is not there
public Integer in(String alphaNumeric,String[] symbols) {
for(int i=0;i<symbols.length;i++)
    {
    if(alphaNumeric.equals(symbols[i])) return(i);
    }
return(NOT_FOUND);
}

// Pretty print the computed fractal
public void prettyPrint() {
String str=computedFractal;
size=str.length();
System.out.println("\nPretty print the final fractal (60 characters per line)\n");
System.out.println("-------------------------------------------------------\n");
while(charsPerLine < size) {
    // print out substrings of str of length charsPerLine
    System.out.println(str.substring(0,charsPerLine-1));
    str=str.substring(charsPerLine,size);
    size=str.length();
} 
// print last bit of str
System.out.println(str);
}

} // MakeFractal
