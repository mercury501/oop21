package oop21.disegnaFigure;

public interface IFigura {
    Punto baricentro();
    int inserisciPunto(Punto punto) throws Exception;
    void rimuoviPunto(int pos) throws Exception;
}
