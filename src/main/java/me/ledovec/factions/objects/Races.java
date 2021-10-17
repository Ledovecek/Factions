package me.ledovec.factions.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bukkit.EntityEffect;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Races {

    private String raceName;
    private EntityEffect entityEffect;

}
