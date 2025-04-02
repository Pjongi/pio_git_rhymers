package edu.kis.vh.nursery.list;

/**
 * Implementacja stosu liczb całkowitych (int) przy użyciu dwukierunkowej listy powiązanej.
 * Przechowuje wskaźnik do ostatniego dodanego elementu (szczytu stosu).
 * Zapewnia podstawowe operacje stosu: push, pop, top, isEmpty, isFull.
 *
 * Uwaga: Pole 'i' w tej klasie wydaje się być nieużywane.
 */
public class IntLinkedList {

    /**
     * Wartość zwracana przez top() i pop() gdy stos jest pusty.
     */
    private static final int EMPTY_STACK_VALUE = -1; // Stała z master (nazwa może być lepsza)

    /**
     * Wskaźnik na ostatni (górny) węzeł na liście/stosie.
     * Jeśli lista jest pusta, ma wartość null.
     */
    private Node last; // Prywatne pole (z master), Javadoc z docs

    /**
     * Nieużywane pole klasy. Może być pozostałością lub błędem.
     * Nie mylić z parametrem i w metodzie push.
     */
    private int i; // Prywatne pole (z master), Javadoc z docs

    /**
     * Dodaje element całkowitoliczbowy na szczyt stosu (koniec listy).
     * Jeśli lista była pusta, nowy węzeł staje się jedynym elementem.
     * W przeciwnym razie, nowy węzeł jest dodawany po aktualnym ostatnim węźle,
     * a wskaźnik 'last' jest aktualizowany.
     *
     * @param value Wartość całkowitoliczbowa do dodania na stos. (zmieniono nazwę parametru dla jasności)
     */
    public void push(int value) { // Publiczne (z docs), Javadoc z docs
        // Ciało metody było identyczne w obu gałęziach
        if (last == null)
            last = new Node(value);
        else {
            last.next = new Node(value);
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
    public boolean isEmpty() { // Publiczne (nie było konfliktu)
        return last == null;
    }

    /**
     * Sprawdza, czy stos (lista) jest pełny.
     * W tej implementacji (lista powiązana) stos teoretycznie nie ma ograniczenia pojemności,
     * więc metoda zawsze zwraca false. Rzeczywistym ograniczeniem jest dostępna pamięć.
     *
     * @return Zawsze zwraca false.
     */
    public boolean isFull() { // Publiczne (nie było konfliktu)
        return false;
    }

    /**
     * Zwraca wartość elementu znajdującego się na szczycie stosu bez jego usuwania.
     *
     * @return Wartość całkowitoliczbowa elementu na szczycie stosu.
     *         Zwraca EMPTY_STACK_VALUE (-1), jeśli stos jest pusty. // Używamy stałej
     */
    public int top() { // Publiczne (z docs), Javadoc z docs
        if (isEmpty())
            return EMPTY_STACK_VALUE; // Użycie stałej (z master)
        return last.value;
    }

    /**
     * Usuwa i zwraca element znajdujący się na szczycie stosu.
     * Aktualizuje wskaźnik 'last', aby wskazywał na poprzedni element.
     *
     * @return Wartość całkowitoliczbowa elementu, który był na szczycie stosu.
     *         Zwraca EMPTY_STACK_VALUE (-1), jeśli stos był pusty przed operacją. // Używamy stałej
     */
    public int pop() { // Publiczne (z docs), Javadoc z docs
        if (isEmpty())
            return EMPTY_STACK_VALUE; // Użycie stałej (z master)
        int ret = last.value;
        last = last.prev;
        // Można opcjonalnie wyzerować wskaźnik next poprzedniego elementu, jeśli istnieje
        if (last != null) {
            last.next = null;
        }
        return ret;
    }

    // Zakładana wewnętrzna klasa Node (brak w kodzie konfliktu, ale potrzebna)
    private static class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
} // Jedna klamra zamykająca klasę