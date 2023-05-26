package com.mycompany.examen;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW
 */
public class Empleado {
    private float salarioBase;

    public Empleado(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    /*
      Salario bruto se calcula sumando al salario base una prima de 100 euros 
      si ventasMes es mayor o igual que 1000 euros, y de 200 euros si fuese al menos de 1500 euros. 
      Además por cada hora extra se pagará a 20 euros. 
      Si ventasMes o horasExtra toman valores negativos el método lanzará una excepción de tipo Exception.
      Salario Bruto = Salario Base + prima + horas extra
     */
    public float calculaSalarioBruto(float ventasMes, float horasExtra) throws Exception{
        float salarioBruto = this.salarioBase;
        if(ventasMes <0 || horasExtra <0 ){
            throw new Exception("Error en salario bruto");
        }
        if (ventasMes >= 1000 && ventasMes < 1500) {
            salarioBruto +=  100; //prima de 100
        }else if(ventasMes >= 1500){
            salarioBruto +=  200; //prima de 200
        }
        salarioBruto += horasExtra * 20; //añadimos horas extra
        return salarioBruto;
    }

    public float calculaSalarioNeto(float salarioBruto, boolean familiaNumerosa, String puesto) throws Exception {
        float salarioNeto = salarioBruto;
        if (salarioBruto < 0 || salarioBruto > 3000) {
            throw new Exception("Error en salario neto");
        } 
        if(familiaNumerosa) {
            salarioNeto += 250; //prima por familia numerosa
        } 
        if (puesto.equalsIgnoreCase("reponedor")) {
            salarioNeto = (float) (salarioBruto * (1 - 0.16));
        }else if (puesto.equalsIgnoreCase("vendedor")) {
            salarioNeto = (float) (salarioBruto * (1 - 0.18));
        }else if (puesto.equalsIgnoreCase("encargado")) {
            salarioNeto = (float) (salarioBruto * (1 - 0.20));
        }
        return salarioNeto;
    }
}
