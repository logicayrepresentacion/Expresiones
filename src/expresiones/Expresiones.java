/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package expresiones;

import java.math.BigInteger;
import java.util.Stack;

/**
 *
 * @author Alejandro Escobar
 */
public class Expresiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String expresion = "4654546456465465488411354875123154898776964 215843248698756546215 +";
        System.out.println("Resultado: " + evaluacionPostfijo(expresion));
    }

    public static String evaluacionPostfijo(String exp) {
        String[] opera = exp.split("\\ ");
        BigInteger resultado = new BigInteger("0");
        BigInteger dos;
        BigInteger uno;
        BigInteger rt;
        Stack<BigInteger> pila = new Stack();
        for (String op : opera) {
            switch (op) {
                case "+":
                    dos = pila.pop();
                    uno = pila.pop();
                    rt = uno.add(dos);
                    pila.push(rt);
                    break;
                case "-":
                    dos = pila.pop();
                    uno = pila.pop();
                    rt = uno.subtract(dos);
                    pila.push(rt);
                    break;
                case "/":
                    dos = pila.pop();
                    uno = pila.pop();
                    rt = uno.divide(dos);
                    pila.push(rt);
                    break;
                case "*":
                    dos = pila.pop();
                    uno = pila.pop();
                    rt = uno.multiply(dos);
                    pila.push(rt);
                    break;
                default:
                    pila.push(new BigInteger(op));
            }
        }
        return resultado.toString();
    }

}
