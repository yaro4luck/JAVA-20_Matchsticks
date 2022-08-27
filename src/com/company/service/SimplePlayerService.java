package com.company.service;

import com.company.repository.SimpleMatchHeapRepository;

import java.util.Scanner;

public class SimplePlayerService implements PlayerService {

    private SimpleMatchHeapRepository matchHeap;

    public SimplePlayerService(SimpleMatchHeapRepository matchHeap) {

        this.matchHeap = matchHeap;

    }

    /**  The wonder number to leave for opponent to provide yourself 100% win is the nearest element of the
     *   following sequence:
     *
     *                wonderNumber = 4*i + 1, i = 0, 1, 2, ...
     *
     *   In counting system with radix 4 this is any number with the most right digit equal to 1. So the only last
     *  digit here in 4-radix equivalent of the number matters! In binary representation it is the two right bits
     *  of the number. So these 2 most right bits should be 0b01 to make the number a wonder number.
     *   For every possible combination of these 2 right bits of current number ( actually there are only four of
     *  them ) the 2 corresponding right bits of the number that is 1 less than current are exactly those that
     *  having been subtracted from current number make its 2 right bits equal to 0b01 that is make the current number
     *  a wonder number, being at the same time within the tolerance for one move ( i.e. less than 4 ):
     *
     *            matchesToRemoveToWin = (numberOfMatches - 1) & 0b11
     */
    @Override
    public int computerMove() {

        return (this.matchHeap.getNumberOfMatches() - 1) & 0b11;

    }

    @Override
    public int userMove() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько спичек убрать? {1, 2, 3}:");

        return scanner.nextInt();
    }

    @Override
    public boolean isValidMove(int matchesToRemove) {

        if ((matchesToRemove < 1) || (matchesToRemove > 3)) {
            return false;
        } else {
            return true;
        }
    }
}
