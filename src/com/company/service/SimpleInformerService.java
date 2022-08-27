package com.company.service;

import com.company.entity.Player;

public class SimpleInformerService implements InformerService {

    @Override
    public void informAboutBeginning() {
        System.out.println("\nИгра началась!");
    }

    @Override
    public void informAboutMatchHeapState(int numberOfMatches) {

        if (numberOfMatches > 4) {
            System.out.println("\nНа столе " + numberOfMatches + " спичек.");
        } else if (numberOfMatches > 1) {
            System.out.println("\nНа столе осталось " + numberOfMatches + " спички.");
        } else if (numberOfMatches == 1) {
            System.out.println("\nНа столе осталась 1 спичка.");
        } else {
            System.out.println("\nВсе спички выбраны.");
        }
    }

    @Override
    public void informAboutCurrentPlayer(Player currentPlayer) {
        System.out.println("Ходит " + currentPlayer.getName() + ".");
    }

    @Override
    public void informAboutMatchesRemovedByPlayer(int numberOfRemovedMatches, Player player) {

        if (numberOfRemovedMatches > 4) {
            System.out.println(player.getName() + " убрал " + numberOfRemovedMatches + " спичек.");
        } else if (numberOfRemovedMatches > 1) {
            System.out.println(player.getName() + " убрал " + numberOfRemovedMatches + " спички.");
        } else if (numberOfRemovedMatches == 1) {
            System.out.println(player.getName() + " убрал 1 спичку.");
        }
    }

    @Override
    public void informAboutInvalidMove() {
        System.out.println("Некорректное значение. Попробуйте ещё раз.");
    }

    @Override
    public void informAboutGameOver() {
        System.out.println("\nИгра окончена!");
    }

    @Override
    public void informAboutWinner(Player winner) {
        System.out.println("Победил " + winner.getName() + ".");
    }
}
