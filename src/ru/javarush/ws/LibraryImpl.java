package ru.javarush.ws;

import javax.jws.WebService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebService(endpointInterface = "ru.javarush.ws.Library")
public class LibraryImpl implements Library {

    private static File books = new File("E:/books");
    private static ArrayList<File> booksFilesArray = new ArrayList<>(Arrays.asList(books.listFiles()));
    private static ArrayList<String> booksNamesArray = new ArrayList<>();
    private static String[] booksNames;
    private static Pattern checkTxt = Pattern.compile("\\.txt$");

    static {
        for(File fileName : booksFilesArray) {
            String name = fileName.getName();
            Matcher match = checkTxt.matcher(name);
            if(match.find())
            booksNamesArray.add(name);
        }
        booksNames = booksNamesArray.toArray(new String[0]);
    }

    @Override
    public String[] getBooksList() {

        return booksNames;
    }

    @Override
    public byte[] getBook(String bookName) {

        String directory = "E:/books/";
        String filePath = directory.concat(bookName);
        byte[] book = null;
        try {
            book = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return book;
        }
    }
}
