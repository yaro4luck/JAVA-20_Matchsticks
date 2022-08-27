package com.company.service;

public interface PlayerService {

    int computerMove();

    int userMove();

    boolean isValidMove(int matchesToRemove);

}
