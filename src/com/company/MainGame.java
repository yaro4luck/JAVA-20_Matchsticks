package com.company;

import com.company.entity.Player;
import com.company.repository.SimpleMatchHeapRepository;
import com.company.repository.SimplePlayerQueueRepository;
import com.company.service.SimpleInformerService;
import com.company.service.SimplePlayerService;

public class MainGame {

    public static void main(String[] args) {

        SimpleInformerService informer = new SimpleInformerService();
        SimpleMatchHeapRepository matchHeap = new SimpleMatchHeapRepository();

        Player user = new Player("Пользователь");
        Player computer = new Player("Компьютер");

        SimplePlayerQueueRepository playerQueue = new SimplePlayerQueueRepository();

        SimplePlayerService playerService = new SimplePlayerService(matchHeap);

        playerQueue.addPlayer(computer);
        playerQueue.addPlayer(user);

        informer.informAboutBeginning();

        while (!matchHeap.isLastMatch() && !matchHeap.isEmpty()) {

            int matchesToRemove;

            informer.informAboutMatchHeapState(matchHeap.getNumberOfMatches());

            Player currentPlayer = playerQueue.getFirstPlayerInQueue();

            informer.informAboutCurrentPlayer(currentPlayer);

            if (currentPlayer == computer) {
                matchesToRemove = playerService.computerMove();
                informer.informAboutMatchesRemovedByPlayer(matchesToRemove, currentPlayer);
            } else {
                matchesToRemove = playerService.userMove();

                while (!playerService.isValidMove(matchesToRemove)) {
                    informer.informAboutInvalidMove();
                    matchesToRemove = playerService.userMove();
                }
            }

            matchHeap.removeMatches(matchesToRemove);
        }

        informer.informAboutMatchHeapState(matchHeap.getNumberOfMatches());
        informer.informAboutGameOver();

        if (matchHeap.isLastMatch()) {
            informer.informAboutWinner(playerQueue.getLastPlayerInQueue());
        } else {
            informer.informAboutWinner(playerQueue.getFirstPlayerInQueue());
        }
    }
}
