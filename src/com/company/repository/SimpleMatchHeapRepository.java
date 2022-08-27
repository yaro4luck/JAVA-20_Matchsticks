package com.company.repository;

public class SimpleMatchHeapRepository implements MatchHeapRepository{

    private final int INITIAL_NUMBER_OF_MATCHES = 20;

    private int numberOfMatches = INITIAL_NUMBER_OF_MATCHES;

    @Override
    public int getNumberOfMatches() {
        return this.numberOfMatches;
    }

    @Override
    public void removeMatches(int matchesToRemove) {
        this.numberOfMatches -= matchesToRemove;
    }

    @Override
    public boolean isLastMatch() {
        return (this.numberOfMatches == 1);
    }

    @Override
    public boolean isEmpty() {
        return (this.numberOfMatches == 0);
    }
}
