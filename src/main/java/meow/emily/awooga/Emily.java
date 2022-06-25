package meow.emily.awooga;

import meow.emily.awooga.ActionEntries.Reflection;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.HeaderElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.user.gui.UserActionGui;
import net.labymod.user.util.UserActionEntry;
import net.labymod.utils.ModColor;

import java.util.List;

public class Emily extends LabyModAddon {

    private static Emily instance;
    private LabyModAddon addon;
    private LabyMod labymod;

    private static final List<UserActionEntry> REGISTERED_USER_ACTION_ENTRIES = (List) Reflection.get(List.class, UserActionGui.class, LabyMod.getInstance().getUserManager().getUserActionGui(), new String[]{"defaultEntries"});

    public static Emily getInstance() {
        return instance;
    }

    private UserActionEntry NameMC() {
        return new UserActionEntry(
                "Open in NameMC",
                UserActionEntry.EnumActionType.OPEN_BROWSER,
                "https://namemc.com/profile/" + "{uuid}",
                (UserActionEntry.ActionExecutor) null
        );
    }

    private UserActionEntry NameMCCopy() {
        return new UserActionEntry(
                "Copy NameMC Link",
                UserActionEntry.EnumActionType.CLIPBOARD,
                "https://namemc.com/profile/" + "{uuid}",
                (UserActionEntry.ActionExecutor) null
        );
    }

    private UserActionEntry LabyNETCopy() {
        return new UserActionEntry(
                "Copy LabyNET Link",
                UserActionEntry.EnumActionType.CLIPBOARD,
                String.format("https://laby.net/@%s", "{name}"),
                (UserActionEntry.ActionExecutor) null
        );
    }

    @Override
    public void onEnable() {
        instance = this;

        REGISTERED_USER_ACTION_ENTRIES.add(LabyNETCopy());
        REGISTERED_USER_ACTION_ENTRIES.add(NameMC());
        REGISTERED_USER_ACTION_ENTRIES.add(NameMCCopy());

        System.out.println("[NMC] Started...");

    }

    @Override
    public void loadConfig() {
        return;
    }

    @Override
    protected void fillSettings(List<SettingsElement> subSettings) {
        subSettings.add(
                new HeaderElement(ModColor.cl('a') + "Welcome to OpenInNameMC"));
        subSettings.add(
                new ButtonElement("GitHub", () -> LabyMod.getInstance().openWebpage(
                        "https://github.com/PrincessAkira/NameMC-1.12", false)));
        subSettings.add(
                new ButtonElement("Creator", () -> LabyMod.getInstance().openWebpage(
                        "https://laby.net/@liebesschwur", false)));
    }

}
