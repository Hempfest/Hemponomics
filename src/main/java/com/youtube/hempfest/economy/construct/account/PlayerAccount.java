package com.youtube.hempfest.economy.construct.account;

import com.youtube.hempfest.economy.construct.account.permissive.AccountType;
import com.youtube.hempfest.economy.construct.entity.EconomyEntity;
import com.youtube.hempfest.economy.construct.entity.types.PlayerEntity;
import org.bukkit.OfflinePlayer;

/**
 * Base class for player-based Accounts.
 * <p>Easily accepts OfflinePlayer and handles entity formation and
 * provide convenience method to retrieve reference to the player</p>
 */
public abstract class PlayerAccount extends Account {
    protected PlayerAccount(AccountType accountType, OfflinePlayer player, EconomyEntity... members) {
        super(accountType, new PlayerEntity(player), members);
    }

    /**
     * Override {@link Account#getHolder()} to return PlayerEntity type.
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
