package meow.emily.awooga;

import net.labymod.settings.SettingsCategory;

// Skidded from https://github.com/l3nnartt/PermaVoice-1.8

public class CategoryElement extends SettingsCategory {

    private final String modTitle;

    public CategoryElement(String title) {
        super(title);
        this.modTitle = title;
    }

    public String getTitle() {
        return this.modTitle;
    }
}
