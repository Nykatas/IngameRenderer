package de.xShequ.utils;

import de.xShequ.gui.UnicodeFontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

import java.text.SimpleDateFormat;
import java.util.Date;

import static net.minecraft.client.gui.Gui.drawRect;

public class IngameRenderer {

    private Minecraft mc = Minecraft.getMinecraft();
    private UnicodeFontRenderer ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);

    private void renderHotbar() {

        int ping;

        String pattern = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        ScaledResolution sr = new ScaledResolution(this.mc);
        drawRect(0, sr.getScaledHeight() - 23, sr.getScaledWidth(), sr.getScaledHeight(), Integer.MIN_VALUE);

        int l = Utils.l;
        int d = Utils.d;
        int g = sr.getScaledWidth();
        int i = (int) ((g - 9 * l - 10 * d) / 2D);
        int id = mc.thePlayer.inventory.currentItem;
        int pos = i + id * l + id * d;
        drawRect(0, sr.getScaledHeight() - 23, sr.getScaledWidth(), sr.getScaledHeight(), -1088874215);
        drawRect(0, sr.getScaledHeight() - 23, 2, sr.getScaledHeight(), -1);
        drawRect(pos, sr.getScaledHeight() - 25, pos + 2 * d + l, sr.getScaledHeight(), -1);

        ufr.drawString("FPS:", 5, sr.getScaledHeight() - 22, 0xffffff);
        ufr.drawString("" + Minecraft.getDebugFPS(), 28, sr.getScaledHeight() - 22, 0xffffff);
        ufr.drawString("" + date, sr.getScaledWidth() - 85, sr.getScaledHeight() - 22, 0xffffff);
        if(mc.isSingleplayer()) {
            ping = 0;
        } else {
            ping = (int) mc.getCurrentServerData().pingToServer;
        }
        ufr.drawString("Ping:", 5, sr.getScaledHeight() - 12, 0xffffff);
        ufr.drawString("" + ping, 28, sr.getScaledHeight() - 12, 0xffffff);
        ufr.drawString("Awesome Hotbar by xShequ!", sr.getScaledWidth() - 85, sr.getScaledHeight() - 12, 0xffffff);

    }

}
