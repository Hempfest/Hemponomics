package com.youtube.hempfest.economy.construct.events;

import com.youtube.hempfest.economy.construct.EconomyAction;
import org.bukkit.event.HandlerList;

public final class AsyncEconomyInfoEvent extends AsyncEconomyActionEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public AsyncEconomyInfoEvent(EconomyAction economyAction) {
        super(economyAction);
    }

    @Override
    public String getConsoleOutput() {
        if (outText != null) return super.getConsoleOutput();
        return String.format("%s: %s [%s] Info: %s",
                entityType,
                economyAction.getActiveHolder().friendlyName(),
                economyAction.isSuccess(),
                economyAction.getInfo());
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
