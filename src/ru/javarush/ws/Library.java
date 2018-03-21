package ru.javarush.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Library {

    @WebMethod
    public String[] getBooksList();

    @WebMethod
    public byte[] getBook(String bookName);
}
