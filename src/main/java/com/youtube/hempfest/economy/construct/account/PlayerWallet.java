package com.youtube.hempfest.economy.construct.account;

import com.youtube.hempfest.economy.construct.entity.types.PlayerEntity;
import org.bukkit.OfflinePlayer;

/**
 * Base class for player-based wallets.
 * <p>Easily accepts OfflinePlayer and handles entity formation and
 * provide convenience method to retrieve reference to the player</p>
 */
public abstract class PlayerWallet extends Wallet {
    protected PlayerWallet(OfflinePlayer player) {
        super(new PlayerEntity(player));
    }

    /**
     * Override {@link Wallet#getHolder()} to return PlayerEntity type.
     * @return {@link PlayerEntity} holder
     */
    @Override
    public PlayerEntity getHolder() {
        return (PlayerEntity) super.getHolder();
    }

    /**
     * Get reference to the player.
     * @return player object
     */
    public OfflinePlayer getPlayer() {
        return getHolder().getPlayer();
    }
}
