package com.company;
/**
 * @author Taras Maslyuk
 */
public interface Box {
    void add(Sweets sweet);

    void deleteLast();

    void deleteInd(int i);

    int countWeight();

    int countPrice();

    void writeInfo();
}
