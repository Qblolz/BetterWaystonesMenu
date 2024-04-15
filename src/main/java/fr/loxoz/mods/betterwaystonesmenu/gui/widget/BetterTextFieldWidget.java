package fr.loxoz.mods.betterwaystonesmenu.gui.widget;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class BetterTextFieldWidget extends EditBox {
    public BetterTextFieldWidget(Font textRenderer, int x, int y, int width, int height, Component message) {
        super(textRenderer, x, y, width, height, message);
    }

    @Override
    public boolean keyPressed(int p_94132_, int p_94133_, int p_94134_) {
        super.keyPressed(p_94132_, p_94133_, p_94134_);
        return canConsumeInput();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 1) {
            setValue("");
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void renderWidget(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.renderWidget(graphics, mouseX, mouseY, partialTicks);
        if (!isVisible()) return;
        if (!getValue().isEmpty()) return;
        graphics.drawString(Minecraft.getInstance().font, getMessage(), getX() + 4, (int) (getY() + (height - 8f) / 2f), 0xff262626, true);
    }

    // because of Forge Gradle we can't use the WidgetCompat class as setX is defined in parent class and gets remapped
    public int _getX() { return getX(); }
    public void _setX(int x) { this.setX(x); }

    public int _getY() { return getY(); }
    public void _setY(int y) { this.setY(y); }

    public void setPosition(int x, int y) {
        _setX(x);
        _setY(y);
    }
}
