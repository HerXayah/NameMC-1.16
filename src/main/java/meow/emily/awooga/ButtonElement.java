package meow.emily.awooga;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.labymod.core.LabyModCore;
import net.labymod.settings.elements.CategorySettingsElement;
import net.labymod.settings.elements.SettingsElement;

// Skidded from https://github.com/l3nnartt/PermaVoice-1.16
public class ButtonElement extends CategorySettingsElement {

    private int length;
    private int x;
    private int y;

    public ButtonElement(String title, Runnable callback) {
        super(
                new CategoryElement(title),
                sc -> {
                    LabyModCore.getMinecraft().playSound(SettingsElement.BUTTON_PRESS_SOUND, 1.0F);
                    callback.run();
                });
    }

    public void draw(int x, int y, int maxX, int maxY, int mouseX, int mouseY) {
        if (this.length != 0) {
            maxX = x + this.x + this.length;
            maxY += this.y;
            x += this.x;
            y += this.y;
        }
        super.draw(new MatrixStack(), x, y, maxX, maxY, mouseX, mouseY);
    }
}