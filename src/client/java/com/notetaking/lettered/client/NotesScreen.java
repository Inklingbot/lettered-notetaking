package com.notetaking.lettered.client;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;

public class NotesScreen extends Screen {
    public NotesScreen() { super(Component.literal("Lettered Notes")); }

    private static final int PANEL_WIDTH = 220;
    private static final int PANEL_HEIGHT = 110;

    @Override
    public void extractBackground(
            GuiGraphicsExtractor graphics,
            int mouseX,
            int mouseY,
            float delta
    ) {
        super.extractBackground(graphics, mouseX, mouseY, delta);

        int panelX = (this.width - PANEL_WIDTH) / 2;
        int panelY = (this.height - PANEL_HEIGHT) / 2;

        graphics.fill(
                panelX,
                panelY,
                panelX + PANEL_WIDTH,
                panelY + PANEL_HEIGHT,
                0xEE20232A
        );

        graphics.outline(
                panelX,
                panelY,
                PANEL_WIDTH,
                PANEL_HEIGHT,
                0xFFFFFFFF
        );
    }

    @Override
    public void extractRenderState(
            GuiGraphicsExtractor graphics,
            int mouseX,
            int mouseY,
            float delta
    ) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.centeredText(
                this.font,
                this.title,
                this.width / 2,
                this.height / 2 - 35,
                0xFFFFFFFF
        );

        graphics.centeredText(
                this.font,
                "Your notes can appear here!",
                this.width / 2,
                this.height / 2 - 10,
                0xFFBFC705
        );
    }

    @Override
    protected void init() {
        int buttonWidth = 80;
        int buttonX = (this.width - buttonWidth) / 2;
        int buttonY = (this.height / 2 + 22);

        Button closeButton = Button.builder(
                Component.translatable("gui.done"),
                button -> this.onClose()
        ).bounds(buttonX, buttonY, buttonWidth, 20).build();

        this.addRenderableWidget(closeButton);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }



}
