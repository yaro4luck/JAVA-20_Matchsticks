package com.company.repository;

public interface MatchHeapRepository {

    int getNumberOfMatches();

    void removeMatches(int matchesToRemove);

    boolean isLastMatch();

    boolean isEmpty();

}
