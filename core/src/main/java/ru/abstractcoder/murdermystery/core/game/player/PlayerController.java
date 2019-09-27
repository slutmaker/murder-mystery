package ru.abstractcoder.murdermystery.core.game.player;

import org.bukkit.GameMode;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import ru.abstractcoder.benioapi.util.optional.BeniOptional;
import ru.abstractcoder.murdermystery.core.game.corpse.Corpse;
import ru.abstractcoder.murdermystery.core.game.corpse.CorpseService;
import ru.abstractcoder.murdermystery.core.game.spectate.SpectatingPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerController {

    private final CorpseService corpseService;
    private final Map<UUID, SpectatingPlayer> spectatingPlayerMap = new HashMap<>();

    public PlayerController(CorpseService corpseService) {
        this.corpseService = corpseService;
    }

    public SpectatingPlayer makeSpectating(GamePlayer gamePlayer, boolean needCorpse) {
        Player player = gamePlayer.getHandle();
        player.getInventory().clear();
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        player.setGameMode(GameMode.SPECTATOR);

        Corpse corpse = null;
        if (needCorpse) {
            corpse = corpseService.spawnCorpse(gamePlayer, player.getLocation());
        }

        SpectatingPlayer spectatingPlayer = new SpectatingPlayer(gamePlayer, corpse);
        spectatingPlayerMap.put(player.getUniqueId(), spectatingPlayer);
        return spectatingPlayer;
    }

    public BeniOptional<SpectatingPlayer> getSpectating(UUID playerId) {
        return BeniOptional.ofNullable(spectatingPlayerMap.get(playerId));
    }

    public boolean removeSpectating(UUID uuid) {
        return spectatingPlayerMap.remove(uuid) != null;
    }

}