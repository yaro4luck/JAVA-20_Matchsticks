package com.company.repository;

import com.company.entity.Player;

public class SimplePlayerQueueRepository implements PlayerQueueRepository {

    private Player[] players = new Player[2];

    @Override
    public void addPlayer(Player player) {

        this.togglePlayers();
        this.players[0] = player;

    }

    @Override
    public Player getFirstPlayerInQueue() {

        this.togglePlayers();
        return this.players[0];

    }

    @Override
    public Player getLastPlayerInQueue() {

        return this.players[0];

    }

    @Override
    public void togglePlayers() {

        Player[] temporaryArrayForPlayers = this.players.clone();

        this.players[0] = temporaryArrayForPlayers[1];
        this.players[1] = temporaryArrayForPlayers[0];

    }
}
