package ru.javarush.endpoint;

import ru.javarush.ws.LibraryImpl;
import javax.xml.ws.Endpoint;

public class LibraryPublisher {

    public static void main (String[] args) {

        Endpoint.publish("http://localhost:1986/wss/lib", new LibraryImpl());
    }
}
