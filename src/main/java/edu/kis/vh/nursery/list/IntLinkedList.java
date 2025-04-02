package edu.kis.vh.nursery.list;

/**
 * Implementacja stosu liczb całkowitych (int) przy użyciu dwukierunkowej listy powiązanej.
 * Przechowuje wskaźnik do ostatniego dodanego elementu (szczytu stosu).
 * Zapewnia podstawowe operacje stosu: push, pop, top, isEmpty.
 *
 * Uwaga: Pole 'i' w tej klasie wydaje się być nieużywane.
 */
public class IntLinkedList {

    /**
     * Wskaźnik na ostatni (górny) węzeł na liście/stosie.
     * Jeśli lista jest pusta, ma wartość null.
     */
    Node last;

    /**
     * Nieużywane pole klasy. Może być pozostałością lub błędem.
     * Nie mylić z parametrem 'i' w metodzie push.
     */
    int i;

    /**
     * Dodaje element całkowitoliczbowy na szczyt stosu (koniec listy).
     * Jeśli lista była pusta, nowy węzeł staje się jedynym elementem.
     * W przeciwnym razie, nowy węzeł jest dodawany po aktualnym ostatnim węźle,
     * a wskaźnik 'last' jest aktualizowany.
     *
     * @param i Wartość całkowitoliczbowa do dodania na stos.
     */
    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            last.next = new Node(i);
            last.next.prev = last;
            last = last.next;
        }
    }

    /**
     * Sprawdza, czy stos (lista) jest pusty.
     *
     * @return true, jeśli stos nie zawiera żadnych elementów (wskaźnik 'last' jest null),
     *         false w przeciwnym wypadku.
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * Sprawdza, czy stos (lista) jest pełny.
     * W tej implementacji (lista powiązana) stos teoretycznie nie ma ograniczenia pojemności,
     * więc metoda zawsze zwraca false. Rzeczywistym ograniczeniem jest dostępna pamięć.
     *
     * @return Zawsze zwraca false.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Zwraca wartość elementu znajdującego się na szczycie stosu bez jego usuwania.
     *
     * @return Wartość całkowitoliczbowa elementu na szczycie stosu.
     *         Zwraca -1, jeśli stos jest pusty (jest to umowna wartość błędu/pustki).
     */
    public int top() {
        if (isEmpty())
            return -1;
        return last.value;
    }

    /**
     * Usuwa i zwraca element znajdujący się na szczycie stosu.
     * Aktualizuje wskaźnik 'last', aby wskazywał na poprzedni element.
     *
     * @return Wartość całkowitoliczbowa elementu, który był na szczycie stosu.
     *         Zwraca -1, jeśli stos był pusty przed operacją (umowna wartość błędu/pustki).
     */
    public int pop() {
        if (isEmpty())
            return -1;
        int ret = last.value;
        last = last.prev;
        return ret;
    }
}