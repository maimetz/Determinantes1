/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Matriz;
import java.util.Scanner;

/**
 *
 * @author Metztoamm
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer n = 3; 

        Integer[][] data = {{-5,46,-22},{23,-5,45},{21,7,2}}; //new Integer[3][3]

        Matriz matriz = new Matriz(n, data);
        System.out.println(matriz.Resolver());
    }
}
