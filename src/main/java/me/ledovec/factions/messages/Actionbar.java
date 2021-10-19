package me.ledovec.factions.messages;

import me.ledovec.factions.Factions;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class Actionbar {

    private String PLAYER_ACTIONBAR_MESSAGE = "§cFactions §8| ";

    private String MSG_1 = "§eHave you tried our crates yet? §e§lTRY IT";
    private String MSG_2 = "§eVisit your website §6www.fc-server.net§e!";

    Random random = new Random();

    public void setPlayerActionBar(Player player) {
        player = Bukkit.getPlayer(player.getName());
        Player finalPlayer = player;
        ArrayList arrayList = getMessagesArray();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Factions.getPlugin(Factions.class), () ->
                finalPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                        TextComponent.fromLegacyText(PLAYER_ACTIONBAR_MESSAGE + arrayList.get(random.nextInt(arrayList.size())))),
                0L, 5L);
    }

    private ArrayList getMessagesArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(MSG_1);
        arrayList.add(MSG_2);
        return arrayList;
    }

}
