package priorityQ;

import api.ColaPTDA;

public class ColaEP implements ColaPTDA {
    int[] values;
    int[] priorities;
    int cant;

    @Override
    public void InicializarCola() {
        values = new int[20];
        priorities = new int[20];
        cant = 0;
    }

    @Override
    public void Acolar(int x, int prioridad) {
        if(ColaVacia()){
            values[cant] = x;
            priorities[cant] = prioridad;
            cant++;
        }else if(prioridad >= priorities[cant-1]) {
            values[cant] = x;
            priorities[cant] = prioridad;
            cant++;
        }else{
            for (int i = 0; i < cant; i++){
                if(priorities[i] > prioridad){
                    for (int j = cant; j > i; j--){
                        values[j] = values[j - 1];
                        priorities[j] = priorities[j - 1];
                    }
                    values[i] = x;
                    priorities[i] = prioridad;
                    cant++;
                    break;
                }
            }
        }
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < cant - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }
        cant--;
    }

    @Override
    public int Prioridad() {
        return priorities[0];
    }

    @Override
    public int Primero() {
        return values[0];
    }

    @Override
    public boolean ColaVacia() {
        return (cant == 0);
    }

    @Override
    public void showCola() {
        System.out.print("<");
        for (int i = 0; i < cant; i++) {
            System.out.print("( " + values[i] + " " + priorities[i] + " )");
            if(i != cant - 1) {
                System.out.print(",");
            }
        }
        System.out.println(">");
    }
}
