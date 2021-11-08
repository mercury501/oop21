package oop21.intercorso;

public interface IPoligono {
    int inserisciPunto(Punto punto) throws Exception;
    void rimuoviPunto(int pos) throws Exception;
    double calcolaPerimetro() throws Exception;
}
