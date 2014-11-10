package com.example.dbproject;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import android.os.*;
import android.util.*;

import java.util.*;

public class Data {
        public static final String TAG = Data.class.getSimpleName();
        
        public static List<Pair<String, List<Book>>> getAllData() {
                List<Pair<String, List<Book>>> res = new ArrayList<Pair<String, List<Book>>>();
                
                for (int i = 0; i < 4; i++) {
                        res.add(getOneSection(i));
                }
                
                return res;
        }
        
        public static List<Book> getFlattenedData() {
                 List<Book> res = new ArrayList<Book>();
                 
                 for (int i = 0; i < 4; i++) {
                         res.addAll(getOneSection(i).second);
                 }
                 
                 return res;
        }
        
        public static Pair<Boolean, List<Book>> getRows(int page) {
                List<Book> flattenedData = getFlattenedData();
                if (page == 1) {
                        return new Pair<Boolean, List<Book>>(true, flattenedData.subList(0, 6));
                } else {
                        SystemClock.sleep(2000); // simulate loading
                        return new Pair<Boolean, List<Book>>(page * 5 < flattenedData.size(), flattenedData.subList((page - 1) * 5, Math.min(page * 5, flattenedData.size())));
                }
        }
        
        public static Pair<String, List<Book>> getOneSection(int index) {
                String[] titles = {"Renaissance", "Baroque", "Classical", "Romantic"};
                Book[][] books = {
                        {
                                new Book("Thomas Tallis", "1510-1585"),
                                new Book("Josquin Des Prez", "1440-1521"),
                                new Book("Pierre de La Rue", "1460-1518"),
                        },
                        {
                                new Book("Johann Sebastian Bach", "1685-1750"),
                                new Book("George Frideric Handel", "1685-1759"),
                                new Book("Antonio Vivaldi", "1678-1741"),
                                new Book("George Philipp Telemann", "1681-1767"),
                        },
                        {
                                new Book("Franz Joseph Haydn", "1732-1809"),
                                new Book("Wolfgang Amadeus Mozart", "1756-1791"),
                                new Book("Barbara of Portugal", "1711Ð1758"),
                                new Book("Frederick the Great", "1712Ð1786"),
                                new Book("John Stanley", "1712Ð1786"),
                                new Book("Luise Adelgunda Gottsched", "1713Ð1762"),
                                new Book("Johann Ludwig Krebs", "1713Ð1780"),
                                new Book("Carl Philipp Emanuel Bach", "1714Ð1788"),
                                new Book("Christoph Willibald Gluck", "1714Ð1787"),
                                new Book("Gottfried August Homilius", "1714Ð1785"),
                        },
                        {
                                new Book("Ludwig van Beethoven", "1770-1827"),
                                new Book("Fernando Sor", "1778-1839"),
                                new Book("Johann Strauss I", "1804-1849"),
                        },
                        {
                            new Book("Franz Joseph Haydn", "1732-1809"),
                            new Book("Wolfgang Amadeus Mozart", "1756-1791"),
                            new Book("Barbara of Portugal", "1711Ð1758"),
                            new Book("Frederick the Great", "1712Ð1786"),
                            new Book("John Stanley", "1712Ð1786"),
                            new Book("Luise Adelgunda Gottsched", "1713Ð1762"),
                            new Book("Johann Ludwig Krebs", "1713Ð1780"),
                            new Book("Carl Philipp Emanuel Bach", "1714Ð1788"),
                            new Book("Christoph Willibald Gluck", "1714Ð1787"),
                            new Book("Gottfried August Homilius", "1714Ð1785"),
                    },
                    {
                        new Book("Franz Joseph Haydn", "1732-1809"),
                        new Book("Wolfgang Amadeus Mozart", "1756-1791"),
                        new Book("Barbara of Portugal", "1711Ð1758"),
                        new Book("Frederick the Great", "1712Ð1786"),
                        new Book("John Stanley", "1712Ð1786"),
                        new Book("Luise Adelgunda Gottsched", "1713Ð1762"),
                        new Book("Johann Ludwig Krebs", "1713Ð1780"),
                        new Book("Carl Philipp Emanuel Bach", "1714Ð1788"),
                        new Book("Christoph Willibald Gluck", "1714Ð1787"),
                        new Book("Gottfried August Homilius", "1714Ð1785"),
                },
                {
                    new Book("Franz Joseph Haydn", "1732-1809"),
                    new Book("Wolfgang Amadeus Mozart", "1756-1791"),
                    new Book("Barbara of Portugal", "1711Ð1758"),
                    new Book("Frederick the Great", "1712Ð1786"),
                    new Book("John Stanley", "1712Ð1786"),
                    new Book("Luise Adelgunda Gottsched", "1713Ð1762"),
                    new Book("Johann Ludwig Krebs", "1713Ð1780"),
                    new Book("Carl Philipp Emanuel Bach", "1714Ð1788"),
                    new Book("Christoph Willibald Gluck", "1714Ð1787"),
                    new Book("Gottfried August Homilius", "1714Ð1785"),
            },
            {
                new Book("Franz Joseph Haydn", "1732-1809"),
                new Book("Wolfgang Amadeus Mozart", "1756-1791"),
                new Book("Barbara of Portugal", "1711Ð1758"),
                new Book("Frederick the Great", "1712Ð1786"),
                new Book("John Stanley", "1712Ð1786"),
                new Book("Luise Adelgunda Gottsched", "1713Ð1762"),
                new Book("Johann Ludwig Krebs", "1713Ð1780"),
                new Book("Carl Philipp Emanuel Bach", "1714Ð1788"),
                new Book("Christoph Willibald Gluck", "1714Ð1787"),
                new Book("Gottfried August Homilius", "1714Ð1785"),
        },
        {
            new Book("Franz Joseph Haydn", "1732-1809"),
            new Book("Wolfgang Amadeus Mozart", "1756-1791"),
            new Book("Barbara of Portugal", "1711Ð1758"),
            new Book("Frederick the Great", "1712Ð1786"),
            new Book("John Stanley", "1712Ð1786"),
            new Book("Luise Adelgunda Gottsched", "1713Ð1762"),
            new Book("Johann Ludwig Krebs", "1713Ð1780"),
            new Book("Carl Philipp Emanuel Bach", "1714Ð1788"),
            new Book("Christoph Willibald Gluck", "1714Ð1787"),
            new Book("Gottfried August Homilius", "1714Ð1785"),
    },
                };
                return new Pair<String, List<Book>>(titles[index], Arrays.asList(books[index]));
        }
}
