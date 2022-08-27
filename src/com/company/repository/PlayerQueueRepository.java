package com.company.repository;

import com.company.entity.Player;

public interface PlayerQueueRepository {

    void addPlayer(Player player);

    Player getFirstPlayerInQueue();

    Player getLastPlayerInQueue();

    void togglePlayers();

}
