package ru.abstractcoder.murdermystery.core.game.spectate;

import org.bukkit.Location;
import org.jetbrains.annotations.Nullable;
import ru.abstractcoder.murdermystery.core.cosmetic.Cosmetic;
import ru.abstractcoder.murdermystery.core.game.corpse.Corpse;
import ru.abstractcoder.murdermystery.core.game.player.GamePlayer;
import ru.abstractcoder.murdermystery.core.game.role.GameRole;
import ru.abstractcoder.murdermystery.core.game.skin.container.SkinContainer;
import ru.abstractcoder.murdermystery.core.rating.StatisticRating;
import ru.abstractcoder.murdermystery.core.statistic.PlayerStatistic;
import ru.abstractcoder.murdermystery.core.util.AbstractWrappedPlayer;

import java.util.Collection;

public class SpectatingPlayer extends AbstractWrappedPlayer {

    //TODO redundant field
    private final GameRole cachedRole;
    private final PlayerStatistic cachedStatistic;
    private final StatisticRating cachedRating;
    private final SkinContainer cachedSkinContainer;
    private final Collection<Cosmetic> cachedCosmetics;
    private final Location deathLocation;
    private Corpse corpse;

    public SpectatingPlayer(GamePlayer gamePlayer,
            Location deathLocation, @Nullable Corpse corpse) {
        super(gamePlayer.getHandle());
        cachedRole = gamePlayer.getRole();
        cachedStatistic = gamePlayer.getStatistic();
        cachedRating = gamePlayer.getRating();
        cachedSkinContainer = gamePlayer.getSkinContainer();
        cachedCosmetics = gamePlayer.getCosmetics();
        this.deathLocation = deathLocation;
        this.corpse = corpse;
    }

    public GameRole getCachedRole() {
        return cachedRole;
    }

    public SkinContainer getCachedSkinContainer() {
        return cachedSkinContainer;
    }

    public Corpse getCorpse() {
        return corpse;
    }

    public void setCorpse(Corpse corpse) {
        this.corpse = corpse;
    }

    public Location getDeathLocation() {
        return deathLocation;
    }

    public Collection<Cosmetic> getCachedCosmetics() {
        return cachedCosmetics;
    }

    public PlayerStatistic getCachedStatistic() {
        return cachedStatistic;
    }

    public StatisticRating getCachedRating() {
        return cachedRating;
    }

}