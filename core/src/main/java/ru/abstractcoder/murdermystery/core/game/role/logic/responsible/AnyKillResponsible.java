package ru.abstractcoder.murdermystery.core.game.role.logic.responsible;

import ru.abstractcoder.murdermystery.core.game.player.GamePlayer;

public interface AnyKillResponsible extends Responsible {

    void onAnyKill(GamePlayer killer, GamePlayer victim, DeathState deathState);

}