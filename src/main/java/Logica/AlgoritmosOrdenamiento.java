package Logica;

import java.util.*;

public class AlgoritmosOrdenamiento {

    public static void insercion(Registro[] a, Comparator<Registro> comp) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Registro aux = a[i];
            int k = i - 1;
            while (k >= 0 && comp.compare(a[k], aux) > 0) {
                a[k + 1] = a[k];
                k--;
            }
            a[k + 1] = aux;
        }
    }

    public static void seleccion(Registro[] a, Comparator<Registro> comp) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            Registro menor = a[i];
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (comp.compare(a[j], menor) < 0) {
                    menor = a[j];
                    k = j;
                }
            }
            a[k] = a[i];
            a[i] = menor;
        }
    }

    public static void shell(Registro[] a, Comparator<Registro> comp) {
        int n = a.length;
        int inter = n / 2;
        while (inter > 0) {
            boolean band = true;
            while (band) {
                band = false;
                int i = 0;
                while ((i + inter) < n) {
                    if (comp.compare(a[i], a[i + inter]) > 0) {
                        Registro aux = a[i];
                        a[i] = a[i + inter];
                        a[i + inter] = aux;
                        band = true;
                    }
                    i++;
                }
            }
            inter = inter / 2;
        }
    }

    public static void quickSort(Registro[] A, int ini, int fin, Comparator<Registro> comp) {
        int izq = ini;
        int der = fin;
        int pos = ini;
        boolean band = true;

        while (band) {
            band = false;
            while (comp.compare(A[pos], A[der]) <= 0 && pos != der) {
                der--;
            }
            if (pos != der) {
                Registro aux = A[pos];
                A[pos] = A[der];
                A[der] = aux;
                pos = der;

                while (comp.compare(A[pos], A[izq]) >= 0 && pos != izq) {
                    izq++;
                }
                if (pos != izq) {
                    band = true;
                    aux = A[pos];
                    A[pos] = A[izq];
                    A[izq] = aux;
                    pos = izq;
                }
            }
        }
        if (ini < (pos - 1)) quickSort(A, ini, pos - 1, comp);
        if ((pos + 1) < fin) quickSort(A, pos + 1, fin, comp);
    }

    public static void mergeSort(Registro[] a, Comparator<Registro> comp) {
        if (a.length < 2) return;
        int mid = a.length / 2;
        Registro[] izq = Arrays.copyOfRange(a, 0, mid);
        Registro[] der = Arrays.copyOfRange(a, mid, a.length);
        mergeSort(izq, comp);
        mergeSort(der, comp);
        merge(a, izq, der, comp);
    }

    private static void merge(Registro[] a, Registro[] izq, Registro[] der, Comparator<Registro> comp) {
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            if (comp.compare(izq[i], der[j]) <= 0) {
                a[k++] = izq[i++];
            } else {
                a[k++] = der[j++];
            }
        }
        while (i < izq.length) a[k++] = izq[i++];
        while (j < der.length) a[k++] = der[j++];
    }

    public static void parallelSort(Registro[] a, Comparator<Registro> comp) {
        Arrays.parallelSort(a, comp);
    }

    public static void arrayListSort(ArrayList<Registro> lista, Comparator<Registro> comp) {
        lista.sort(comp);
    }

    public static Resultados medirTiempo(String metodo, List<Registro> datosOriginales, Comparator<Registro> comp) {
        Registro[] copiaArreglo = datosOriginales.toArray(new Registro[0]);
        ArrayList<Registro> copiaLista = null;
        //toma el tiempo inicial
        long inicio = System.nanoTime();

        switch (metodo) {
            case "Insercion":
                insercion(copiaArreglo, comp);
                break;
            case "Seleccion":
                seleccion(copiaArreglo, comp);
                break;
            case "Shell":
                shell(copiaArreglo, comp);
                break;
            case "QuickSort":
                quickSort(copiaArreglo, 0, copiaArreglo.length - 1, comp);
                break;
            case "MergeSort":
                mergeSort(copiaArreglo, comp);
                break;
            case "ParallelSort":
                parallelSort(copiaArreglo, comp);
                break;
            case "ArrayList.sort":
                copiaLista = new ArrayList<>(datosOriginales);
                arrayListSort(copiaLista, comp);
                break;
        }
        //toma el tiempo final
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;

        List<Registro> ordenados = (copiaLista != null) ? copiaLista : Arrays.asList(copiaArreglo);
        return new Resultados(metodo, tiempoMs, ordenados);
    }

   //este metodo mide el tiempo para todos los metodos cuando se ingresa la opcion de todos
    public static List<Resultados> medirTodos(List<Registro> datosOriginales, Comparator<Registro> comp) {
        String[] metodos = {"Insercion", "Seleccion", "Shell", "QuickSort", "MergeSort", "ParallelSort", "ArrayList.sort"};
        List<Resultados> resultados = new ArrayList<>();

        for (String metodo : metodos) {
            resultados.add(medirTiempo(metodo, datosOriginales, comp));
        }
        return resultados;
    }
}