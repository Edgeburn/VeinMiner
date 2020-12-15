package wtf.choco.veinminer.anticheat;

import java.util.Objects;

import me.konsolas.aac.api.AACAPI;
import me.konsolas.aac.api.AACExemption;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

/**
 * The default Advanced AntiCheat (AAC) hook implementation
 */
public final class AntiCheatHookAAC implements AntiCheatHook {

    private final AACExemption exemption = new AACExemption("The player is using VeinMiner");
    private final AACAPI api = Objects.requireNonNull(Bukkit.getServicesManager().load(AACAPI.class));

    @Override
    public String getPluginName() {
        return "AAC5";
    }

    @Override
    public void exempt(@NotNull Player player) {
        this.api.addExemption(player, exemption);
    }

    @Override
    public void unexempt(@NotNull Player player) {
        this.api.removeExemption(player, exemption);
    }

}
