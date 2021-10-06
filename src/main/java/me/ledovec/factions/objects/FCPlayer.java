package me.ledovec.factions.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bukkit.entity.Player;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class FCPlayer {

    private Player player;
    private String name;
    private Races race;

}
