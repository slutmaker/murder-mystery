package ru.abstractcoder.murdermystery.core.game.role.logic.responsible;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;

public interface AnyOwnMoveResponsible extends Responsible {

    void onAnyMove(Location from, Location to, Cancellable event);

}