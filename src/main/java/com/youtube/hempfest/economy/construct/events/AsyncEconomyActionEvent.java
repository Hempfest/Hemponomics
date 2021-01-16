package com.youtube.hempfest.economy.construct.events;

import com.youtube.hempfest.economy.construct.EconomyAction;
import com.youtube.hempfest.economy.construct.entity.EconomyEntity;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AsyncEconomyActionEvent extends Event {

    protected final EconomyAction economyAction;
    protected final Plugin plugin;
    protected final String entityType;
    protected String outText = null;

    protected AsyncEconomyActionEvent(EconomyAction economyAction) {
        super(true);
        this.economyAction = economyAction;
        final Class<? extends EconomyEntity> entityClass = economyAction.getActiveHolder().getClass();
        this.plugin = JavaPlugin.getProvidingPlugin(entityClass);
        this.entityType = !entityClass.isAnonymousClass() ? entityClass.getSimpleName() : entityClass.getSuperclass().getSimpleName();
    }

    /**
     * Get a reference to the Plugin which provided the entity implementation
     * of the EconomyAction.
     * @return Provider plugin
     */
    public Plugin getProvidingPlugin() {
        return plugin;
    }

    /**
     * Get the name of the Entity subclass which provided the EconomyAction's
     * holder implementation. If anonymous, returns nearest superclass.
     * @return Class name, such as PlayerEntity
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set a custom console output.
     * <p>(The default can be found using {@link #getConsoleOutput()}
     * where outText == null)</p>
     * @param outText Desired formatted String
     */
    public void setConsoleOutput(String outText) {
        this.outText = outText;
    }

    /**
     * Get the current console output.
     * <p>If not set, see default result in subclasses.</p>
     * @return ChatColor translation of outText field if not null
     */
    public String getConsoleOutput() {
        return ChatColor.translateAlternateColorCodes('&', outText);
    }

    /**
     * Get the EconomyAction for this event.
     * @return an informative EconomyAction which describes the nature of this event.
     */
    public EconomyAction getEconomyAction() {
        return economyAction;
    }

}
